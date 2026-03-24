### 03 - Parameterized Tests

---

# 1️⃣ Why Parameterized Tests?

In real-world systems, a method rarely has only ONE valid input.

Example:

- Validate email formats
- Test multiple currencies
- Check boundary values
- Test invalid login attempts
- Validate business rules

Without parameterized tests:

- You duplicate test methods
- Code becomes messy
- Maintenance becomes hard

Parameterized tests allow:
✔ Running same test with multiple inputs  
✔ Better coverage  
✔ Cleaner test classes  
✔ Data-driven testing

---

# 2️⃣ What is a Parameterized Test?

A test that runs multiple times with different arguments.

Instead of:

```java

@Test
void test1() {
}

@Test
void test2() {
}

@Test
void test3() {
}
```

We use:

```java

@ParameterizedTest
@ValueSource(ints = {1, 2, 3})
void test(int value) {
}
```

---

# 3️⃣ Required Dependency

JUnit 5 Parameterized support requires:

```xml

<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-params</artifactId>
    <version>5.10.0</version>
    <scope>test</scope>
</dependency>
```

---

# 4️⃣ Common Parameter Sources

## 1️⃣ @ValueSource

For primitive/simple values:

```java
@ValueSource(strings = {"A", "B", "C"})
```

Supports:

- int
- long
- double
- String
- class
- etc.

---

## 2️⃣ @NullSource

Provides null input.

---

## 3️⃣ @EmptySource

Provides empty:

- String
- Collection
- Array

---

## 4️⃣ @NullAndEmptySource

Combination of both.

---

## 5️⃣ @CsvSource

For multiple arguments:

```java
@CsvSource({
        "100, 10, 90",
        "200, 50, 150"
})
```

Each row = one test execution.

---

## 6️⃣ @CsvFileSource

Reads data from external CSV file.

Used in:

- Large validation datasets
- Real-world input simulation

---

## 7️⃣ @MethodSource (Most Powerful)

Supplies arguments from method:

```java
static Stream<Arguments> provideData() {
    return Stream.of(
            Arguments.of(100, 10, 90),
            Arguments.of(200, 50, 150)
    );
}
```

Best for:

- Complex objects
- Dynamic test data
- Reusable datasets

---

# 5️⃣ Lifecycle Behavior

Important:

Each parameterized execution:

- Is treated as separate test
- Runs full lifecycle (@BeforeEach etc.)

---

# 6️⃣ Advanced Concepts

✔ Display names per execution  
✔ Custom argument conversion  
✔ Aggregators  
✔ Enum testing  
✔ Edge case validation

---

# 7️⃣ Real-World Use Cases

✔ Input validation  
✔ Financial calculations  
✔ Boundary testing  
✔ REST API parameter validation  
✔ Discount engine rules  
✔ Authentication attempts

---

# 8️⃣ Interview Questions

Q: Difference between @Test and @ParameterizedTest?  
Q: When to use @MethodSource?  
Q: How to test null values?  
Q: How lifecycle behaves with parameterized tests?  
Q: Can parameterized test be static?

---

# 9️⃣ Best Practices

✔ Use descriptive display names  
✔ Avoid too many parameters  
✔ Use MethodSource for complex cases  
✔ Avoid heavy logic in test method  
✔ Combine with assertAll for state validation

---

# 🔟 Common Mistakes

❌ Forgetting junit-jupiter-params dependency  
❌ Using non-static MethodSource without @TestInstance  
❌ Mixing parameterized and normal annotations  
❌ Hardcoding business logic in test

---
