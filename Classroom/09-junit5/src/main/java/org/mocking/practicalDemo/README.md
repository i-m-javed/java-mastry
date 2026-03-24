# 02 - Mockito Practical (Advanced)

---

# 1️⃣ Why Advanced Mockito Matters

In real systems:

- Dependencies have multiple methods
- Behavior changes per scenario
- Exceptions must be simulated
- Interactions must be verified precisely
- Method arguments must be captured

Basic mocking is not enough.

Advanced Mockito allows:

✔ Annotation-based mocking  
✔ Automatic injection  
✔ Argument capturing  
✔ Exception stubbing  
✔ Partial mocking (Spy)  
✔ Verification modes

---

# 2️⃣ Mockito with JUnit 5 (Recommended Setup)

Use MockitoExtension:

```java
@ExtendWith(MockitoExtension.class)
```

Benefits:

- No manual mock() creation
- Cleaner tests
- Automatic injection

---

# 3️⃣ @Mock Annotation

Instead of:

```java
TaxPolicy policy = mock(TaxPolicy.class);
```

We use:

```java

@Mock
TaxPolicy policy;
```

Mockito initializes automatically.

---

# 4️⃣ @InjectMocks

Automatically injects mocks into class under test.

```java

@InjectMocks
InvoiceService service;
```

Mockito will:

- Find matching constructor
- Inject mock dependencies

---

# 5️⃣ Verification Modes

```java
verify(policy, times(1)).

calculateTax(1000);

verify(policy, never()).

calculateTax(500);

verify(policy, atLeastOnce()).

calculateTax(anyDouble());
```

Interview favorite question.

---

# 6️⃣ Argument Matchers

Used when exact values not important.

```java
when(policy.calculateTax(anyDouble())).

thenReturn(100.0);
```

Common matchers:

- any()
- anyDouble()
- eq(value)
- isNull()
- notNull()

⚠ You must use matchers consistently.

---

# 7️⃣ ArgumentCaptor (Very Important)

Used to capture method arguments for deeper validation.

```java
ArgumentCaptor<Double> captor = ArgumentCaptor.forClass(Double.class);

verify(policy).

calculateTax(captor.capture());

double capturedValue = captor.getValue();
```

Used when:

- You need to inspect argument
- You need custom assertion

---

# 8️⃣ Stubbing Exceptions

Simulate dependency failure:

```java
when(policy.calculateTax(anyDouble()))
        .

thenThrow(new RuntimeException("Tax service down"));
```

Used to test:

- Error handling
- Fallback logic
- Resilience patterns

---

# 9️⃣ doThrow / doAnswer

Used when stubbing void methods.

```java
doThrow(new RuntimeException())
        .

when(service).

someVoidMethod();
```

doAnswer allows custom behavior.

---

# 🔟 Spy (Partial Mock)

Spy wraps real object.

```java
TaxPolicy realPolicy = new RealTaxPolicy();
TaxPolicy spyPolicy = spy(realPolicy);
```

Allows:

- Partial override
- Real method execution
- Selective stubbing

Used carefully.

---
