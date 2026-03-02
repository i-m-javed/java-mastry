# 01 - Mocking Fundamentals

---

# 1️⃣ Why Mocking Exists

In unit testing, we test ONE class in isolation.

But real classes depend on:

- Database
- External APIs
- Payment gateways
- Email services
- Tax services
- Third-party SDKs

If we test with real dependencies:
❌ Tests become slow  
❌ Tests become flaky  
❌ Tests require network/database  
❌ Tests become integration tests

Mocking solves this.

---

# 2️⃣ What is a Mock?

A Mock is a fake object that:

✔ Replaces a real dependency  
✔ Returns controlled responses  
✔ Allows interaction verification

It is a type of:

👉 Test Double

---

# 3️⃣ Types of Test Doubles

| Type  | Purpose                     |
|-------|-----------------------------|
| Dummy | Just placeholder            |
| Stub  | Returns predefined data     |
| Mock  | Verifies interactions       |
| Spy   | Partial real object         |
| Fake  | Lightweight working version |

Mockito mainly creates:

- Mocks
- Spies

---

# 4️⃣ Why Mocking Improves Design

Mocking forces:

✔ Dependency injection  
✔ Loose coupling  
✔ Interface-based design  
✔ Better abstraction

If mocking is hard → your design is bad.

---

# 5️⃣ Real Problem Without Mocking

Suppose TaxPolicy calls:

- Government API
- External tax server

If we don’t mock:

- Every unit test calls external API
- Tests slow down
- Tests break if API down

That’s not unit testing.

---

# 6️⃣ What is Mockito?

Mockito is a mocking framework for Java.

It allows:

✔ Creating mock objects  
✔ Stubbing methods  
✔ Verifying interactions  
✔ Controlling behavior

---

# 7️⃣ Maven Dependency

```xml

<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>5.8.0</version>
    <scope>test</scope>
</dependency>
```

---

# 8️⃣ Core Mockito Concepts

## Create Mock

```java
TaxPolicy policy = mock(TaxPolicy.class);
```

## Stubbing

```java
when(policy.calculateTax(1000)).

thenReturn(100.0);
```

## Verification

```java
verify(policy).

calculateTax(1000);
```

---

# 9️⃣ Mock vs Stub (Interview Important)

Stub:

- Only returns predefined data.

Mock:

- Also verifies interaction.

Example question:
"How do you verify that dependency method was called?"

Answer:
Using `verify()` in Mockito.

---

# 🔟 When NOT to Mock

❌ Value objects  
❌ Simple POJOs  
❌ Pure functions  
❌ Collections

Mock only:

- External systems
- Complex dependencies
- Side-effect components

---

# 1️⃣1️⃣ Common Interview Questions

Q: What is mocking?  
Q: Difference between stub and mock?  
Q: Why use dependency injection for mocking?  
Q: What happens if you mock concrete classes tightly coupled?  
Q: What is a spy?

---
