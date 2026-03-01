# Lambda Expressions

## 1. Why Lambda Was Introduced

Before Java 8, Java lacked:

- Functional programming capability
- Clean behavior passing
- Concise callback syntax
- Internal iteration mechanisms

Java was purely object-oriented and verbose.

Example (Pre-Java 8):

```java
Collections.sort(list, new Comparator<String>() {
    @Override
    public int compare(String a, String b) {
        return a.compareTo(b);
    }
});
```

This is verbose and hard to read.

Java 8 introduced:

> Lambda Expressions

To support:

- Functional programming style
- Behavior parameterization
- Stream API
- Cleaner APIs

---

## 2. What is a Lambda Expression?

A Lambda expression is:

> A concise way to represent an anonymous function.

Syntax:

```java
(parameters) -> expression
```

Or:

```java
(parameters) -> { block of code }
```

---

## 3. Lambda = Anonymous Class Replacement

Before Java 8:

```java
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Running");
    }
};
```

With Lambda:

```java
Runnable r = () -> System.out.println("Running");
```

Much cleaner.

---

## 4. Functional Interface – Core Requirement

Lambda works only with:

> Functional Interfaces

Definition:

An interface with exactly ONE abstract method.

Example:

```java
@FunctionalInterface
interface Printer {
    void print(String message);
}
```

Why only one abstract method?

Because Lambda needs a target type.

This is called:

> Target Typing

---

## 5. Behavioral Parameterization

Lambda allows passing behavior as data.

Example:

```java
process(() -> System.out.println("Task executed"));
```

Instead of passing objects, we pass logic.

This is fundamental for:

- Stream API
- Executors
- Callbacks
- Event handling

---

## 6. Internal vs External Iteration

External iteration (old style):

```java
for (String s : list) {
    System.out.println(s);
}
```

Internal iteration (functional style):

```java
list.forEach(s -> System.out.println(s));
```

Control shifts from developer to library.

This is a major paradigm shift.

---

## 7. Key Features of Lambda

✔ Reduces boilerplate  
✔ Enables functional programming  
✔ Supports Stream API  
✔ Supports parallelism  
✔ Cleaner APIs

---

## 8. Lambda Syntax Variations

### Single Parameter

```java
x -> x * 2
```

### Multiple Parameters

```java
(a, b) -> a + b
```

### Block Body

```java
(x, y) -> {
    int sum = x + y;
    return sum;
}
```

### No Parameters

```java
() -> System.out.println("Hello")
```

---

## 9. Under the Hood (Important)

Lambda does NOT create anonymous class.

Java uses:

> invokedynamic bytecode instruction

This makes Lambdas:

- Lightweight
- Efficient
- Better performing than anonymous classes

Interview-level point.

---

## 10. Limitations

- Cannot modify local variables unless effectively final
- Cannot be used without functional interface
- Cannot have multiple abstract methods in target interface

---

## 11. Real-World Usage

Lambda is used in:

- Stream API
- ExecutorService
- CompletableFuture
- Spring Framework
- Functional programming patterns
- Event handling systems

---

## 12. Interview Questions

1. What is a Lambda expression?
2. What is a functional interface?
3. Why only one abstract method allowed?
4. Difference between anonymous class and lambda?
5. What is effectively final?
6. How is lambda implemented internally?

---

## Conclusion

Lambda expressions mark the beginning of:

> Functional Programming in Java.

They enable:

- Cleaner code
- Behavior passing
- Stream processing
- Modern API design
