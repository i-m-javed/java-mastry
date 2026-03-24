### 01 - JUnit 5 Fundamentals

---

# 1️⃣ Why Testing is Critical in Enterprise Applications

In real-world enterprise systems:

- Code is modified frequently
- Multiple developers work on same modules
- Refactoring is common
- Regression risk is high

Unit Testing ensures:

- Code correctness
- Confidence during refactoring
- Faster debugging
- Better design
- CI/CD compatibility

Testing is not optional in production systems.

---

# 2️⃣ What is JUnit?

JUnit is a testing framework for Java.

Current Industry Standard:

- JUnit 5 (Jupiter API)

Official Modules:

- JUnit Platform
- JUnit Jupiter
- JUnit Vintage (for JUnit 4 support)

---

# 3️⃣ Maven Dependency (JUnit 5)

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.0</version>
    <scope>test</scope>
</dependency>
```

---

# 4️⃣ Basic Structure of a Test Class

```java
class CalculatorTest {

    @Test
    void testAddition() {
        // Arrange
        // Act
        // Assert
    }
}
```

---

# 5️⃣ Core Annotations

| Annotation   | Purpose                    |
| ------------ | -------------------------- |
| @Test        | Marks a test method        |
| @BeforeEach  | Runs before every test     |
| @AfterEach   | Runs after every test      |
| @BeforeAll   | Runs once before all tests |
| @AfterAll    | Runs once after all tests  |
| @DisplayName | Custom test name           |
| @Disabled    | Skip test                  |

---

# 6️⃣ Assertions (Critical for Interviews)

Assertions verify expected behavior.

Common Assertions:

```java
assertEquals(expected, actual);
assertNotEquals(expected, actual);
assertTrue(condition);
assertFalse(condition);
assertNull(value);
assertNotNull(value);
assertThrows(Exception.class, () -> method());
```

---

# 7️⃣ Test Lifecycle

Execution Flow:

1. @BeforeAll
2. @BeforeEach
3. @Test
4. @AfterEach
5. @AfterAll

Each test method:

- Runs independently
- Should not depend on other tests

---

# 8️⃣ Arrange-Act-Assert Pattern

Professional test structure:

Arrange → Setup data  
Act → Execute method  
Assert → Verify output

This improves:

- Readability
- Maintainability
- Debugging

---

# 9️⃣ Exception Testing

JUnit 5 way:

```java
assertThrows(ArithmeticException.class, () -> {
    calculator.divide(10, 0);
});
```

Never use try-catch inside tests unless required.

---

# 🔟 Good Test Design Principles

✔ One behavior per test  
✔ Independent tests  
✔ No shared mutable state  
✔ Deterministic tests  
✔ Descriptive method names  
✔ No business logic inside test

---

# 1️⃣1️⃣ Common Interview Questions

Q: Difference between JUnit 4 and JUnit 5?

- JUnit 5 supports lambda-based assertions
- Modular architecture
- More flexible lifecycle

Q: What is unit testing?
Testing individual units (methods/classes) in isolation.

Q: What is code coverage?
Percentage of code executed by tests.

Q: Can private methods be tested?
No directly — test via public methods.

Q: What is mocking?
Simulating dependencies (covered later with Mockito).

---

# 1️⃣2️⃣ Real-World Importance

JUnit is used in:

- Banking systems
- Microservices
- Spring Boot applications
- CI/CD pipelines
- Enterprise deployments

Without tests → No production-grade system.

---
