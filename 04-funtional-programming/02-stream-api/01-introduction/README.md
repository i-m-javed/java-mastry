# Stream API

## 1. Why Stream API Was Introduced

Before Java 8, collection processing looked like:

```java
for (String name : list) {
    if (name.startsWith("A")) {
        System.out.println(name.toUpperCase());
    }
}
```

Problems:

- Verbose
- Imperative style
- Hard to parallelize
- External iteration
- Mixing business logic with looping

Java 8 introduced:

> Stream API

To enable:

✔ Declarative programming  
✔ Functional-style processing  
✔ Internal iteration  
✔ Parallel processing  
✔ Cleaner pipeline-based data operations

---

## 2. What is a Stream?

A Stream is:

> A sequence of elements supporting aggregate operations.

Important:

- Stream does NOT store data
- It processes data from a source
- It supports lazy evaluation
- It can be sequential or parallel

---

## 3. Stream vs Collection

| Collection         | Stream                      |
| ------------------ | --------------------------- |
| Stores data        | Does NOT store data         |
| External iteration | Internal iteration          |
| Eager execution    | Lazy execution              |
| Mutable            | Functional-style processing |

---

## 4. How Stream Works

Stream pipeline consists of:

```
Source → Intermediate Operations → Terminal Operation
```

Example:

```java
list.stream()
    .filter(s -> s.startsWith("A"))
    .map(String::toUpperCase)
    .forEach(System.out::println);
```

---

## 5. Internal Iteration

Old approach (external iteration):

```java
for (String s : list) { ... }
```

Stream approach (internal iteration):

```java
list.forEach(System.out::println);
```

Library controls iteration.

This enables:

- Parallel processing
- Optimization
- Cleaner logic

---

## 6. Stream Characteristics

✔ Does not modify original data  
✔ Processes elements on demand  
✔ Supports functional composition  
✔ Can be parallelized

---

## 7. Lazy Evaluation

Intermediate operations are lazy.

They execute only when terminal operation is called.

Example:

```java
list.stream()
    .filter(s -> {
        System.out.println("Filtering: " + s);
        return s.length() > 3;
    });
```

Nothing executes until terminal operation like:

```java
.forEach(...)
```

---

## 8. Stream Creation Methods

From Collection:

```java
list.stream();
```

From Arrays:

```java
Arrays.stream(array);
```

From Stream class:

```java
Stream.of("A", "B", "C");
```

Infinite Streams:

```java
Stream.generate(...)
Stream.iterate(...)
```

---

## 9. Why Streams Matter in Backend Systems

Streams are used in:

- Data transformation
- Filtering results
- Aggregation
- Report generation
- Mapping DTOs
- Processing API responses
- Parallel computation

---

## 10. Sequential vs Parallel Streams

Sequential:

```java
list.stream()
```

Parallel:

```java
list.parallelStream()
```

Parallel streams use:

> ForkJoinPool (common pool)

Used for CPU-intensive tasks.

---

## 12. Production Insight

Stream improves:

- Code readability
- Functional clarity
- Maintainability
- Parallel scalability

But:

- Not always best for simple loops
- Overuse can reduce readability
- Must understand performance trade-offs

---

## Conclusion

Stream API marks a paradigm shift:

From imperative → declarative  
From loops → pipelines  
From external control → internal iteration
