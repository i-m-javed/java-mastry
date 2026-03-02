### 04 - Nested Tests

---

# 1️⃣ Why Nested Tests Exist

In real-world applications, behavior is often state-dependent.

Example:

- Account when active
- Account when inactive
- Order before processing
- Order after processing
- User when authenticated
- User when not authenticated

Without nested tests:

- Test classes become flat
- State grouping is unclear
- Maintenance becomes hard

Nested tests allow:
✔ Logical grouping of related tests  
✔ Better readability  
✔ Behavior-based structuring  
✔ Clear separation of state scenarios

---

# 2️⃣ What is @Nested?

JUnit 5 provides:

```
@Nested
```

Used on a non-static inner class to group related tests.

Important:

- Only works in JUnit 5
- Nested classes must NOT be static
- Each nested class represents a context

---

# 3️⃣ Concept: Behavior-Driven Structure

Instead of writing:

```
testWithdrawWhenActive()
testWithdrawWhenInactive()
testDepositWhenActive()
testDepositWhenInactive()
```

We structure like:

```
BankAccountTest
    WhenAccountIsActive
        withdraw()
        deposit()

    WhenAccountIsInactive
        withdraw()
        deposit()
```

This improves:

- Readability
- Logical grouping
- Professional structure

---

# 4️⃣ Lifecycle Behavior in Nested Tests

Important Interview Concept:

Outer class lifecycle methods:

- @BeforeEach
- @AfterEach

Run before nested tests too.

Nested classes can also define:

- Their own @BeforeEach
- Their own @AfterEach

Execution Order:

1. Outer @BeforeEach
2. Nested @BeforeEach
3. Test
4. Nested @AfterEach
5. Outer @AfterEach

---

# 5️⃣ Real-World Use Cases

✔ Stateful service testing  
✔ Role-based access control  
✔ Multi-phase processing  
✔ Payment lifecycle validation  
✔ Authentication flow testing

---

# 6️⃣ Advantages

✔ Improves maintainability  
✔ Reduces duplication  
✔ Cleaner behavior grouping  
✔ Makes test reports clearer

---

# 7️⃣ Limitations

❌ Cannot be static  
❌ Too many nested levels reduce readability  
❌ Avoid business logic inside nested classes

---

# 8️⃣ Interview Questions

Q: Why use nested tests instead of multiple test classes?  
Q: How does lifecycle behave with nested tests?  
Q: Can nested classes be static?  
Q: Can nested tests access outer variables?  
Q: Difference between test hierarchy and nested tests?

---

# 9️⃣ Best Practices

✔ Use descriptive class names like:

- WhenUserIsLoggedIn
- WhenOrderIsProcessed
- WhenBalanceIsInsufficient

✔ Keep max 2 nesting levels
✔ Avoid heavy initialization inside nested classes
✔ Use @DisplayName for clarity

---
