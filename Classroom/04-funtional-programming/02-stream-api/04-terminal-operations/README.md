# Stream Terminal Operations – Execution & Aggregation Phase

## 1. What Are Terminal Operations?

Terminal operations:

✔ Trigger execution of the stream pipeline  
✔ Produce a non-stream result  
✔ Close the stream  
✔ Cannot be reused after execution

Without a terminal operation:

```
Nothing executes.
```

---

## 2. Characteristics

| Feature           | Terminal Operation                   |
| ----------------- | ------------------------------------ |
| Returns           | Value / Optional / Collection / void |
| Executes Pipeline | Yes                                  |
| Lazy              | No                                   |
| Reusable          | No (stream is consumed)              |

---

# 3. Core Terminal Operations

---

## 3.1 forEach()

Consumes elements.

```java
stream.forEach(System.out::println);
```

Used for:

- Printing
- Logging
- Side-effects

⚠ Not recommended for complex mutation logic.

---

## 3.2 collect()

Most powerful terminal operation.

Used to transform stream into:

- List
- Set
- Map
- Grouped results
- Custom structures

Example:

```java
.collect(Collectors.toList())
```

---

## 3.3 count()

Counts elements.

```java
long count = stream.count();
```

---

## 3.4 reduce()

Combines elements into single result.

```java
stream.reduce((a, b) -> a + b);
```

Used for:

- Sum
- Multiplication
- Accumulation logic

---

## 3.5 min() & max()

Find smallest/largest element.

```java
stream.max(Comparator.comparing(...));
```

Returns Optional.

---

## 3.6 findFirst() & findAny()

Returns Optional.

- findFirst() → Deterministic
- findAny() → Faster in parallel streams

---

## 3.7 Matching Operations

✔ anyMatch  
✔ allMatch  
✔ noneMatch

Used for:

- Validation
- Condition checks

---

# 4. Optional Return Type

Some terminal operations return:

```
Optional<T>
```

Used to avoid:

- NullPointerException
- Unsafe null checks

Example:

```java
Optional<Employee> emp = stream.findFirst();
```

---

# 5. Reduce vs Collect

| reduce()            | collect()         |
| ------------------- | ----------------- |
| Immutable reduction | Mutable reduction |
| Functional          | Collector-based   |
| Simpler aggregation | Complex grouping  |

Use reduce for:

- Numeric aggregation

Use collect for:

- Transforming structure

---

# 6. Stream Reusability

After terminal operation:

```java
stream.forEach(...);
stream.count(); // ERROR
```

Stream is consumed.

Must create new stream.

---

# 7. Real Backend Example

Processing API response:

```
Fetch → Filter → Map → Reduce → Return value
```

Or:

```
Fetch → Group → Collect → Return DTO
```

Terminal operation is final step.

---

# 8. Short-Circuiting Operations

Some terminal operations stop early:

- findFirst
- findAny
- anyMatch
- noneMatch
- allMatch

They improve performance.

---
