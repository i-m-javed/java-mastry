# Functional Interfaces

## 1. What is a Functional Interface?

A Functional Interface is:

> An interface with exactly ONE abstract method.

Also called:

- SAM (Single Abstract Method) Interface

Lambda expressions can only be assigned to functional interfaces.

---

## 2. Why Exactly One Abstract Method?

Lambda represents:

> A single piece of behavior

If interface had multiple abstract methods:

Compiler would not know which method the lambda is implementing.

Therefore, functional interface must contain:

✔ Exactly one abstract method  
✔ Can contain multiple default methods  
✔ Can contain multiple static methods

---

## 3. @FunctionalInterface Annotation

Example:

```java
@FunctionalInterface
interface Printer {
    void print(String message);
}
```

This annotation:

✔ Enforces compile-time validation  
✔ Prevents accidental addition of abstract methods  
✔ Improves readability

If you add another abstract method → compilation error.

---

## 4. Functional Interface Can Have:

### 1️⃣ One Abstract Method

Mandatory.

### 2️⃣ Default Methods

```java
default void log() {
    System.out.println("Logging...");
}
```

### 3️⃣ Static Methods

```java
static void helper() {
    System.out.println("Helper method");
}
```

---

## 5. Built-in Functional Interfaces (java.util.function)

Java 8 introduced standard functional interfaces.

### Core Ones:

| Interface     | Purpose                   |
| ------------- | ------------------------- |
| Predicate<T>  | Takes T → returns boolean |
| Function<T,R> | Takes T → returns R       |
| Consumer<T>   | Takes T → returns void    |
| Supplier<T>   | Takes nothing → returns T |

---

## 6. Predicate Example

```java
Predicate<Integer> isEven = x -> x % 2 == 0;
```

Used in:

- Filtering
- Validation logic

---

## 7. Function Example

```java
Function<String, Integer> length = s -> s.length();
```

Used in:

- Mapping
- Transformations

---

## 8. Consumer Example

```java
Consumer<String> printer = s -> System.out.println(s);
```

Used in:

- Iteration
- Logging
- Side-effects

---

## 9. Supplier Example

```java
Supplier<Double> randomValue = () -> Math.random();
```

Used in:

- Lazy initialization
- Object creation
- Value generation

---

## 10. Custom Functional Interface Design

When to create custom?

✔ Domain-specific behavior  
✔ Business logic abstraction  
✔ Strategy pattern  
✔ Callback mechanisms

Avoid creating custom if built-in already exists.

---

## 11. Functional Interface & Polymorphism

Lambda implements functional interface.

Example:

```java
Runnable r = () -> System.out.println("Run");
```

Runnable is functional interface.

---

## 12. How Lambda Binds to Interface

Compiler performs:

> Target typing

Example:

```java
Printer p = message -> System.out.println(message);
```

Compiler infers:

- message type from interface method
- return type automatically

---

## Conclusion

Functional Interfaces are:

- The backbone of Lambda expressions
- Foundation of functional programming in Java
- Core building block of Stream API
