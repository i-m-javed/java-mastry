# Collectors

## 1. What is a Collector?

A Collector is used with:

```java
stream.collect(...)
```

It performs:

✔ Mutable reduction  
✔ Aggregation  
✔ Grouping  
✔ Partitioning  
✔ Transformation

Collectors are located in:

```
java.util.stream.Collectors
```

---

## 2. Why Collectors Matter

Collectors are essential for:

- Converting streams to collections
- Grouping business data
- Generating reports
- Creating maps
- Data transformation pipelines

Without collectors, streams are incomplete.

---

## 3. Basic Collectors

### 3.1 toList()

```java
.collect(Collectors.toList())
```

### 3.2 toSet()

```java
.collect(Collectors.toSet())
```

### 3.3 toMap()

```java
.collect(Collectors.toMap(
    Employee::getId,
    Employee::getName
))
```

⚠ Duplicate keys cause exception.

---

## 4. groupingBy()

Groups elements based on classifier function.

Example:

```java
.collect(Collectors.groupingBy(
    Employee::getDepartment
))
```

Returns:

```
Map<Department, List<Employee>>
```

---

## 5. partitioningBy()

Special case of grouping.

Divides into two groups:

```java
.collect(Collectors.partitioningBy(
    e -> e.getSalary() > 50000
))
```

Returns:

```
Map<Boolean, List<Employee>>
```

---

## 6. joining()

Used for string concatenation.

```java
.collect(Collectors.joining(", "))
```

---

## 7. summarizingInt / summarizingDouble

Provides statistics:

- Count
- Sum
- Min
- Max
- Average

Example:

```java
.collect(Collectors.summarizingDouble(Employee::getSalary))
```

Returns DoubleSummaryStatistics.

---

## 8. mapping()

Used inside grouping to transform values.

Example:

```java
.collect(Collectors.groupingBy(
    Employee::getDepartment,
    Collectors.mapping(Employee::getName, Collectors.toList())
))
```

---

## 9. counting()

Counts grouped elements.

```java
.collect(Collectors.groupingBy(
    Employee::getDepartment,
    Collectors.counting()
))
```

---

## 10. collectingAndThen()

Applies finishing transformation.

Example:

```java
.collect(Collectors.collectingAndThen(
    Collectors.toList(),
    Collections::unmodifiableList
))
```

---

## 11. Custom Collector (Advanced)

Collectors internally use:

- Supplier
- Accumulator
- Combiner
- Finisher

This is rarely required but important for interviews.

---

## 12. Reduce vs Collect

| reduce              | collect           |
| ------------------- | ----------------- |
| Immutable reduction | Mutable reduction |
| Functional          | Collector-based   |
| Numeric aggregation | Complex grouping  |

Use collect for structure-building.

---
