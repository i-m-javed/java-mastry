# Exception Handling in Java

## 1. Introduction

Exception Handling in Java is a structured mechanism to:

✔ Detect runtime errors  
✔ Maintain program flow  
✔ Separate error-handling logic  
✔ Build resilient systems

Java follows:

> Object-Oriented Exception Model

All exceptions derive from:

```java
java.lang.Throwable
```

---

# 2. Exception Hierarchy

```
Throwable
 ├── Error
 └── Exception
      ├── RuntimeException
      └── Checked Exceptions
```

---

## 2.1 Error

- Serious JVM problems
- Not meant to be handled
- Example:
  - OutOfMemoryError
  - StackOverflowError

---

## 2.2 Checked Exceptions

- Checked at compile-time
- Must be handled or declared
- Represent recoverable conditions

Examples:

- IOException
- SQLException
- ClassNotFoundException

---

## 2.3 Unchecked Exceptions (RuntimeException)

- Occur at runtime
- Not mandatory to handle
- Usually programming mistakes

Examples:

- NullPointerException
- ArithmeticException
- IndexOutOfBoundsException

---

# 3. Checked vs Unchecked – Design Philosophy

Checked:
✔ Forces caller awareness  
✔ Used for recoverable scenarios

Unchecked:
✔ Represents programming bugs  
✔ Avoids excessive try-catch clutter

Enterprise systems mostly prefer:

> Unchecked exceptions for business logic.

---

# 4. try-catch-finally

Basic structure:

```java
try {
    // risky code
} catch (Exception e) {
    // handling
} finally {
    // cleanup
}
```

Finally block:
✔ Always executes  
✔ Used for resource cleanup

---

# 5. try-with-resources

Introduced in Java 7.

Automatically closes resources implementing:

```java
AutoCloseable
```

Example:

```java
try (BufferedReader br = new BufferedReader(...)) {
    // use resource
}
```

Cleaner and safer than finally.

---

# 6. throw vs throws

throw:

- Used to explicitly throw exception

throws:

- Declares exception in method signature

---

# 7. Custom Exceptions

Why create custom exceptions?

✔ Clear business intent  
✔ Domain-specific error handling  
✔ Better debugging

Example:

```java
class InsufficientBalanceException extends Exception {
}
```

---

# 8. Exception Propagation

If exception is not handled:
It propagates up the call stack.

This is called:

> Stack unwinding

Understanding this is critical for layered systems.

---

# 9. Best Practices

✔ Catch specific exceptions  
✔ Avoid catching Exception blindly  
✔ Never swallow exceptions  
✔ Log exceptions properly  
✔ Use try-with-resources  
✔ Prefer unchecked for business rules  
✔ Avoid overusing checked exceptions

---

# 10. Anti-Patterns

❌ Empty catch blocks  
❌ Catching Throwable  
❌ Using exceptions for control flow  
❌ Overusing checked exceptions  
❌ Printing stack trace in production

---

# 11. Production Insight

Exception design affects:

- Transaction rollback
- API response structure
- Logging strategy
- Microservices stability
- Security auditing

Good exception handling = stable backend system.

---
