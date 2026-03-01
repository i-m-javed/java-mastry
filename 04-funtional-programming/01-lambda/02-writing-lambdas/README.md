# Writing Lambda Expressions

## 1. Recap: Lambda Basics

Lambda Syntax:

```java
(parameters) -> expression
```

or

```java
(parameters) -> { block }
```

But writing lambdas correctly requires understanding:

- Type inference
- Scope rules
- Effectively final variables
- Variable capture
- This reference behavior
- Return rules

This is where interviews go deeper.

---

# 2. Type Inference

Java compiler infers parameter types from the target functional interface.

Example:

```java
Comparator<String> comparator = (a, b) -> a.compareTo(b);
```

You don’t need to write:

```java
(String a, String b)
```

Because compiler already knows types.

---

## When Type Must Be Explicit

When inference becomes ambiguous:

```java
BinaryOperator<Integer> op = (Integer a, Integer b) -> a + b;
```

Explicit types improve readability in complex lambdas.

---

# 3. Parameter Syntax Variations

### Single Parameter (No Parentheses)

```java
x -> x * 2
```

### Multiple Parameters (Parentheses Required)

```java
(a, b) -> a + b
```

### No Parameters

```java
() -> System.out.println("Hello")
```

---

# 4. Block Body vs Expression Body

### Expression Body (Implicit Return)

```java
(a, b) -> a + b
```

Return is automatic.

### Block Body (Explicit Return Required)

```java
(a, b) -> {
    int sum = a + b;
    return sum;
}
```

If block is used → return is mandatory.

---

# 5. Effectively Final Variables

Lambda can only access:

> Final or Effectively Final variables

Example:

```java
int x = 10;

Runnable r = () -> System.out.println(x);
```

This works.

But:

```java
x = 20;  // Now x is not effectively final → compilation error
```

---

## Why?

Because Lambda captures variable value, not variable reference.

It ensures thread safety and predictability.

---

# 6. Variable Capture

Lambda can capture:

✔ Local variables (if effectively final)  
✔ Instance variables  
✔ Static variables

Example:

```java
int local = 10;

Runnable r = () -> System.out.println(local);
```

---

# 7. Lambda Scope vs Anonymous Class Scope

In anonymous class:

```java
this refers to anonymous class instance
```

In lambda:

```java
this refers to enclosing class
```

This is a major difference.

---

# 8. Lambda Cannot:

❌ Have instance variables  
❌ Have constructors  
❌ Declare multiple abstract methods  
❌ Modify local variables

Because it is not a class.

---

# 9. Common Mistakes

❌ Trying to modify captured variable  
❌ Forgetting return in block body  
❌ Confusing lambda with method

---

# 10. Production Insight

Understanding lambda scope is critical in:

- Multithreading
- Stream pipelines
- Event handling
- Asynchronous programming
- Executor services

Incorrect variable capture can cause subtle bugs.

---

# Conclusion

Writing lambdas properly requires understanding:

- Compiler inference
- Scope rules
- Variable capture
- Behavioral constraints
