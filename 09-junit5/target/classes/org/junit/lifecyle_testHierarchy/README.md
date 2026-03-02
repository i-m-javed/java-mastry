### 05 - Lifecycle and Test Hierarchy

---

# 1️⃣ Why Lifecycle Understanding Is Critical

Many bugs in unit tests occur because developers do not understand:

- When objects are created
- When setup runs
- How test instances are managed
- How nested tests interact
- Whether state is shared or isolated

JUnit lifecycle determines:
✔ Test isolation  
✔ Memory usage  
✔ State safety  
✔ Thread behavior  
✔ Parallel execution safety

---

# 2️⃣ Default Lifecycle: PER_METHOD (Important)

By default, JUnit creates:

👉 A new test class instance for every test method.

This is called:

```
TestInstance.Lifecycle.PER_METHOD
```

Meaning:

```
@Test method 1 → new object
@Test method 2 → new object
@Test method 3 → new object
```

Advantages:
✔ Complete isolation  
✔ No shared state  
✔ Safe by default

---

# 3️⃣ Alternative Lifecycle: PER_CLASS

You can change lifecycle:

```java
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
```

Now:

👉 Only ONE test class instance is created.

All tests share same instance.

Use case:

- Expensive setup
- Shared resources
- Integration-style testing

⚠ Risk:
Shared mutable state can cause flaky tests.

---

# 4️⃣ Lifecycle Annotations

| Annotation  | Scope            | Runs             |
|-------------|------------------|------------------|
| @BeforeAll  | Once             | Before all tests |
| @AfterAll   | Once             | After all tests  |
| @BeforeEach | Before each test | Every test       |
| @AfterEach  | After each test  | Every test       |

---

# 5️⃣ Static Rule (Interview Favorite)

With PER_METHOD (default):

- @BeforeAll must be static
- @AfterAll must be static

With PER_CLASS:

- They can be non-static

This is a very common interview question.

---

# 6️⃣ Execution Order (Full Flow)

For each test:

1. @BeforeAll (once)
2. Create test instance
3. @BeforeEach
4. @Test
5. @AfterEach
6. Destroy instance
7. @AfterAll (once)

---

# 7️⃣ Nested Test Lifecycle

For nested tests:

Execution order becomes:

Outer @BeforeEach  
Inner @BeforeEach  
@Test  
Inner @AfterEach  
Outer @AfterEach

Understanding this is critical for debugging.

---

# 8️⃣ Test Hierarchy

Hierarchy example:

```
OuterTest
    NestedClass1
        TestA
        TestB
    NestedClass2
        TestC
```

JUnit sees:

- Each nested class as separate context
- But shares outer instance (depending on lifecycle)

---

# 9️⃣ State Sharing Rules

Default (PER_METHOD):

- No state sharing between test methods

PER_CLASS:

- State shared
- Risk of test pollution

Best practice:
✔ Prefer PER_METHOD
✔ Avoid mutable shared fields
✔ Reset state in @BeforeEach

---

# 🔟 Parallel Execution Impact

If using parallel testing:

PER_METHOD → Safe  
PER_CLASS → Dangerous unless synchronized

---

# 1️⃣1️⃣ When To Use PER_CLASS

✔ Expensive DB container setup  
✔ Large data initialization  
✔ Integration testing  
✔ Caching scenarios

Not recommended for:

- Simple unit tests

---

# 1️⃣2️⃣ Common Interview Questions

Q: What is default lifecycle in JUnit 5?  
Q: Why must @BeforeAll be static?  
Q: When to use PER_CLASS?  
Q: How nested lifecycle behaves?  
Q: What causes flaky tests?

---

# 1️⃣3️⃣ Best Practices

✔ Keep tests isolated  
✔ Avoid shared mutable state  
✔ Prefer PER_METHOD  
✔ Use @BeforeEach for resetting  
✔ Avoid heavy logic in @BeforeAll

---
