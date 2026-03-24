# 07 - Repeating Tests & Dynamic Tests

---

# 1️⃣ Why Repeating and Dynamic Tests Exist

Not all test scenarios are static.

Real-world needs:

✔ Retrying flaky operations  
✔ Stress testing logic  
✔ Randomized input testing  
✔ Generating test cases at runtime  
✔ Testing multiple datasets dynamically

JUnit provides:

- @RepeatedTest
- @TestFactory (Dynamic Tests)

---

# 2️⃣ Repeating Tests

## @RepeatedTest

Runs the same test multiple times.

Example:

```java

@RepeatedTest(5)
void repeatTest() {
}
```

Use cases:

✔ Detect flaky behavior  
✔ Test concurrency  
✔ Validate random logic  
✔ Retry network simulations

---

# 3️⃣ RepetitionInfo Injection

JUnit can inject:

```java
void test(RepetitionInfo repetitionInfo)
```

You can access:

- Current repetition
- Total repetitions

---

# 4️⃣ Custom Display Names

```java
@RepeatedTest(value = 3, name = "{displayName} - Run {currentRepetition}/{totalRepetitions}")
```

---

# 5️⃣ When to Use Repeated Tests

✔ Random number generators  
✔ Time-sensitive logic  
✔ Stress validation  
✔ Retrying unstable external calls

Not for:
❌ Data-driven testing (use Parameterized instead)

---

# 6️⃣ Dynamic Tests

Dynamic tests are created at runtime.

Annotation used:

```
@TestFactory
```

Return type must be:

- Collection<DynamicTest>
- Stream<DynamicTest>
- Iterable<DynamicTest>

---

# 7️⃣ Why Dynamic Tests?

Parameterized tests require known data at compile time.

Dynamic tests allow:

✔ Runtime data generation  
✔ Complex object test creation  
✔ Conditional test creation  
✔ Database-driven test generation

---

# 8️⃣ Dynamic Test Example Structure

```java

@TestFactory
Stream<DynamicTest> dynamicTests() {
    return Stream.of(1, 2, 3)
            .map(num -> DynamicTest.dynamicTest(
                    "Test " + num,
                    () -> assertTrue(num > 0)
            ));
}
```

Each element becomes independent test.

---

# 9️⃣ Difference: Parameterized vs Dynamic

| Feature            | Parameterized | Dynamic                  |
|--------------------|---------------|--------------------------|
| Compile-time data  | Yes           | Not required             |
| Runtime generation | Limited       | Full support             |
| IDE reporting      | Better        | Slightly less structured |
| Use case           | Data-driven   | Runtime-driven           |

---

# 🔟 Lifecycle Behavior

Important:

Dynamic tests:

- Do NOT support @BeforeEach per dynamic test
- Only factory method has lifecycle support

Interview favorite question.

---

# 1️⃣1️⃣ When To Use Dynamic Tests

✔ Generating tests from DB records  
✔ Generating tests from file input  
✔ Validating complex object graph  
✔ Creating custom DSL-based tests

---

# 1️⃣2️⃣ Common Interview Questions

Q: Difference between RepeatedTest and ParameterizedTest?  
Q: When to use DynamicTest?  
Q: Does @BeforeEach run for each DynamicTest?  
Q: Can DynamicTest be nested?  
Q: Which is better for large datasets?

---

# 1️⃣3️⃣ Best Practices

✔ Use RepeatedTest for reliability testing  
✔ Use Parameterized for input variations  
✔ Use Dynamic only when runtime generation required  
✔ Keep dynamic test names descriptive  
✔ Avoid complex logic inside lambda

---
