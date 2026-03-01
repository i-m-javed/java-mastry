# Stream API with Collections

## 1. Why This Topic Matters

Collections store data.
Streams process data.

In backend systems, 90% of business logic involves:

- Filtering
- Mapping
- Sorting
- Aggregating
- Transforming
- Collecting results

This module connects:

Collections → Functional Processing → Business Logic

---

# 2. Common Stream Operations on Collections

When working with collections, streams are used for:

✔ Filtering data  
✔ Transforming data  
✔ Sorting objects  
✔ Aggregating values  
✔ Converting to different collections  
✔ Removing duplicates  
✔ Matching conditions

---

# 3. Filtering Collections

Example:

```java
list.stream()
    .filter(e -> e.getSalary() > 50000)
    .collect(Collectors.toList());
```

Used in:

- Business rule filtering
- Validation pipelines
- Report generation

---

# 4. Mapping Collections

Transform objects:

```java
list.stream()
    .map(Employee::getName)
    .collect(Collectors.toList());
```

Mapping is used for:

- DTO conversion
- Data transformation
- Extracting fields

---

# 5. Sorting Collections Using Stream

Natural order:

```java
list.stream().sorted();
```

Custom order:

```java
list.stream()
    .sorted(Comparator.comparing(Employee::getSalary))
```

---

# 6. Removing Duplicates

```java
list.stream()
    .distinct()
```

Internally uses:

- equals()
- hashCode()

---

# 7. Matching Operations

✔ anyMatch  
✔ allMatch  
✔ noneMatch

Example:

```java
list.stream()
    .anyMatch(e -> e.getSalary() > 100000);
```

Used in:

- Validation logic
- Condition checks
- Business rule enforcement

---

# 8. Aggregation

Common aggregation methods:

✔ count()  
✔ sum() (via mapping)  
✔ max()  
✔ min()  
✔ reduce()

Example:

```java
double totalSalary = list.stream()
    .mapToDouble(Employee::getSalary)
    .sum();
```

---

# 9. Converting Stream Back to Collection

Using Collectors:

```java
.collect(Collectors.toList())
.collect(Collectors.toSet())
.collect(Collectors.toMap())
```

---

# 10. Pipeline Pattern

A stream pipeline follows:

```
Source → Intermediate Operations → Terminal Operation
```

Example:

```java
list.stream()
    .filter(...)
    .map(...)
    .sorted(...)
    .collect(...);
```

---

# 11. Production Insight

Streams improve:

✔ Code readability  
✔ Business logic clarity  
✔ Data transformation pipelines  
✔ Declarative programming

But avoid:

❌ Overusing streams for simple tasks  
❌ Nested streams that reduce readability  
❌ Complex logic inside lambdas

---

# Conclusion

Stream with Collections is the foundation of:

- Modern Java backend development
- Data transformation
- Business rule pipelines
- Clean service-layer logic
