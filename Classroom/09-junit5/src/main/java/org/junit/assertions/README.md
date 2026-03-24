### 02 - Assertions

---

# 1️⃣ Why Assertions Matter

Assertions are the backbone of unit testing.

Without assertions:

- A test runs but verifies nothing.
- False positives occur.
- Bugs reach production.

Assertions validate:

- Expected output
- Exception behavior
- State transitions
- Object equality
- Performance boundaries

A test without assertion is not a test.

---

# 2️⃣ Core Assertion Categories in JUnit 5

JUnit 5 Assertions are in:

org.junit.jupiter.api.Assertions

We can categorize them into:

1. Equality Assertions
2. Boolean Assertions
3. Null Assertions
4. Exception Assertions
5. Grouped Assertions
6. Timeout Assertions
7. Identity Assertions

---

# 3️⃣ Equality Assertions

## assertEquals()

```java
assertEquals(expected, actual);
```

Important:

- Order matters (expected first).
- Uses equals() internally for objects.

### Floating Point Comparison

```java
assertEquals(10.5, result, 0.01);
```

Delta parameter avoids precision errors.

---

## assertNotEquals()

Verifies values are different.

---

# 4️⃣ Boolean Assertions

```java
assertTrue(condition);
assertFalse(condition);
```

Prefer meaningful messages:

```java
assertTrue(balance > 0, "Balance must always remain positive");
```

---

# 5️⃣ Null Assertions

```java
assertNull(object);
assertNotNull(object);
```

Used for:

- Lazy initialization
- Optional validation
- Database fetch results

---

# 6️⃣ Identity Assertions

## assertSame()

Checks reference equality (==)

## assertNotSame()

Ensures two objects are not same reference.

Critical difference:

assertEquals() → logical equality  
assertSame() → memory reference equality

Interview favorite question.

---

# 7️⃣ Exception Assertions (Lambda-Based)

JUnit 5 uses lambda:

```java
assertThrows(ExceptionType.class, () -> {
    methodCall();
});
```

Advanced usage:

```java
Exception ex = assertThrows(IllegalArgumentException.class,
    () -> service.process(-1));

assertEquals("Invalid input", ex.getMessage());
```

Very important for enterprise validation logic.

---

# 8️⃣ Grouped Assertions

Ensures multiple validations execute:

```java
assertAll(
    () -> assertEquals("Javed", user.getName()),
    () -> assertTrue(user.isActive()),
    () -> assertNotNull(user.getEmail())
);
```

If one fails:

- Others still execute.
- All failures reported.

Used in:

- DTO validation
- API response validation

---

# 9️⃣ Timeout Assertions

Prevents infinite loops or performance regression.

```java
assertTimeout(Duration.ofSeconds(2), () -> {
    service.processLargeData();
});
```

Two types:

- assertTimeout → waits
- assertTimeoutPreemptively → interrupts

Interview Question:
Which is safer in multi-threaded environments?

Answer:
assertTimeout (non-preemptive).

---

# 🔟 Lazy Assertion Messages (Performance Insight)

Bad:

```java
assertEquals(a, b, expensiveMethod());
```

Better:

```java
assertEquals(a, b, () -> expensiveMethod());
```

Message created only if test fails.

---

# 1️⃣1️⃣ Best Practices

✔ Always put expected first  
✔ Test one behavior per test  
✔ Avoid logic inside test  
✔ Prefer descriptive messages  
✔ Use grouped assertions for state validation  
✔ Use delta for double comparisons  
✔ Capture exception to assert message

---

# 1️⃣2️⃣ Common Interview Questions

Q: Difference between assertEquals and assertSame?  
Q: Why use delta for double?  
Q: What is grouped assertion?  
Q: Difference between assertTimeout and assertTimeoutPreemptively?  
Q: Why expected value first?

---

# 📌 Summary

Assertions ensure:

- Behavioral correctness
- State validation
- Exception safety
- Performance limits

Mastering assertions makes you a strong backend engineer.

Next:
03 - Parameterized Tests
