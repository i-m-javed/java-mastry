# Stream Intermediate Operations

## 1. What Are Intermediate Operations?

Intermediate operations:

✔ Transform a stream  
✔ Return a new Stream  
✔ Are lazy (not executed immediately)  
✔ Require a terminal operation to execute

Pipeline structure:

```
Source → Intermediate Operations → Terminal Operation
```

Without terminal operation, nothing runs.

---

## 2. Characteristics

| Feature         | Intermediate Operation |
| --------------- | ---------------------- |
| Returns         | Stream                 |
| Execution       | Lazy                   |
| Chainable       | Yes                    |
| Modifies Source | No                     |

---

# 3. Core Intermediate Operations

## 3.1 filter()

Filters elements based on condition.

```java
stream.filter(e -> e.getSalary() > 50000)
```

Used for:

- Business rule enforcement
- Validation
- Data selection

---

## 3.2 map()

Transforms element to another form.

```java
stream.map(Employee::getName)
```

Used for:

- DTO mapping
- Field extraction
- Data transformation

---

## 3.3 flatMap()

Used for flattening nested structures.

Example:

```java
List<List<String>> data;
data.stream()
    .flatMap(List::stream)
```

Used when:

- Working with nested collections
- Flattening hierarchical data

Interview favorite.

---

## 3.4 distinct()

Removes duplicates using:

- equals()
- hashCode()

---

## 3.5 sorted()

Natural sorting:

```java
.sorted()
```

Custom sorting:

```java
.sorted(Comparator.comparing(...))
```

---

## 3.6 limit()

Restricts number of elements.

```java
.limit(5)
```

Used for:

- Pagination
- Top-N results

---

## 3.7 skip()

Skips first N elements.

```java
.skip(5)
```

Used for:

- Pagination offset

---

## 3.8 peek()

Used for debugging.

```java
.peek(System.out::println)
```

Does not modify elements.

⚠ Should not be used for business logic.

---

# 4. Lazy Evaluation Demonstration

Nothing executes until terminal operation.

Example:

```java
stream.filter(...)
      .map(...)
```

No execution until:

```java
.collect(...)
.forEach(...)
```

---

# 5. Ordering Matters

Operations are executed in pipeline order.

Example:

```java
stream.filter(...)
      .limit(3)
```

More efficient than:

```java
stream.limit(3)
      .filter(...)
```

Understanding order improves performance.

---

# 6. Real-World Backend Example

Processing API results:

```
Fetch → Filter Active → Map DTO → Sort → Limit Top 10 → Return
```

Streams model this perfectly.

---

# 8. Production Insight

Correct pipeline ordering:

- Improves performance
- Reduces memory usage
- Avoids unnecessary computation

Poor ordering:

- Wastes CPU cycles
- Creates unnecessary objects

Senior engineers optimize pipeline flow.

---
