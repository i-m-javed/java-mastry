# Types of Functional Interfaces

## 1. Introduction

Java 8 introduced several built-in functional interfaces under:

```
java.util.function
```

These interfaces are categorized based on:

- Number of input parameters
- Return type
- Whether primitive specialization exists
- Whether it consumes, produces, or transforms data

Understanding these types is critical for:

- Stream API
- Functional programming
- Performance-sensitive systems
- Interview depth

---

# 2. Core Functional Interface Categories

| Category  | Description                                     |
| --------- | ----------------------------------------------- |
| Predicate | Boolean condition check                         |
| Function  | Transforms input to output                      |
| Consumer  | Consumes input (no return)                      |
| Supplier  | Produces output (no input)                      |
| Operator  | Specialized function (same input & output type) |

---

# 3. UnaryOperator & BinaryOperator

## UnaryOperator<T>

Specialization of Function<T, T>

```java
UnaryOperator<Integer> square = x -> x * x;
```

Input and output types are same.

---

## BinaryOperator<T>

Specialization of BiFunction<T, T, T>

```java
BinaryOperator<Integer> sum = (a, b) -> a + b;
```

Used in:

- Stream reduce()
- Mathematical operations

---

# 4. Bi-Functional Interfaces

For two input parameters:

| Interface         | Signature       |
| ----------------- | --------------- |
| BiPredicate<T,U>  | (T,U) → boolean |
| BiFunction<T,U,R> | (T,U) → R       |
| BiConsumer<T,U>   | (T,U) → void    |

Example:

```java
BiPredicate<Integer, Integer> isGreater = (a, b) -> a > b;
```

---

# 5. Chaining Functional Interfaces

Function supports chaining:

```java
Function<Integer, Integer> multiplyBy2 = x -> x * 2;
Function<Integer, Integer> add5 = x -> x + 5;

Function<Integer, Integer> combined =
        multiplyBy2.andThen(add5);
```

---

# 6. Predicate Chaining

```java
Predicate<Integer> isEven = x -> x % 2 == 0;
Predicate<Integer> isPositive = x -> x > 0;

Predicate<Integer> combined =
        isEven.and(isPositive);
```

Logical operations:

- and()
- or()
- negate()

---

# 7. Real-World Usage

These interfaces are heavily used in:

- Stream API
- Optional
- CompletableFuture
- Reactive programming
- Spring framework

---
