# 08 - Test Interfaces & Default Methods

---

# 1️⃣ Why Test Interfaces Exist

In enterprise systems:

You often have:

- Multiple implementations of same interface
- Different service strategies
- Multiple repository types
- Multiple payment processors
- Different algorithm implementations

You want:
✔ To test shared behavior once  
✔ Apply same test contract to all implementations  
✔ Avoid duplicate test code

JUnit 5 allows test methods inside interfaces.

---

# 2️⃣ What Is a Test Interface?

In JUnit 5:

- Interfaces can contain @Test methods
- Default methods can define test logic
- Implementing classes inherit those tests

This is called:

👉 **Reusable Test Contracts**

---

# 3️⃣ Why Is This Powerful?

Instead of:

```
StripePaymentTest
PaypalPaymentTest
UPIPaymentTest
```

Each repeating same test logic…

You create:

```
PaymentContractTest (interface)
```

And each implementation test just supplies instance.

---

# 4️⃣ Basic Structure

```
interface MyContractTest {

    SomeType createInstance();

    @Test
    default void testSomething() {
        SomeType instance = createInstance();
        // common assertions
    }
}
```

Implementing class:

```
class ConcreteTest implements MyContractTest {
    public SomeType createInstance() {
        return new ConcreteImplementation();
    }
}
```

---

# 5️⃣ Why Default Methods?

Default methods allow:

- Providing implementation
- Sharing logic
- Avoiding duplication

JUnit executes default @Test methods.

---

# 6️⃣ Real-World Use Cases

✔ Repository implementations  
✔ Service strategy validation  
✔ Algorithm comparison  
✔ Interface contract enforcement  
✔ Generic behavior testing

---

# 7️⃣ Advantages

✔ DRY principle  
✔ Clean architecture  
✔ Better maintainability  
✔ Consistent behavior validation  
✔ Easier refactoring

---

# 8️⃣ Limitations

❌ Harder for beginners to understand  
❌ IDE navigation slightly complex  
❌ Too many layers can reduce readability

---

# 9️⃣ Interview Questions

Q: Can test methods exist inside interfaces?  
Q: Why would we use test interfaces?  
Q: How does lifecycle behave with test interfaces?  
Q: Can interface define @BeforeEach?  
Q: Difference between abstract class vs interface for shared tests?

---

# 🔟 Abstract Class vs Interface

| Feature              | Abstract Class | Interface     |
|----------------------|----------------|---------------|
| Multiple inheritance | No             | Yes           |
| Default method       | Yes            | Yes           |
| Flexible reuse       | Limited        | More flexible |
| Preferred in JUnit 5 | Interface      |

---

# 1️⃣1️⃣ Lifecycle Behavior

Lifecycle annotations:

- @BeforeEach
- @AfterEach

Can also be placed in interface default methods.

They execute in implementing class context.

---

# 1️⃣2️⃣ Best Practices

✔ Keep interface focused on behavior  
✔ Avoid heavy setup logic  
✔ Use factory method (createInstance())  
✔ Keep naming descriptive  
✔ Avoid static fields

---
