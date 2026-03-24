# Comparable vs Comparator

## 1. Why Sorting Matters

Sorting is fundamental in:

- Lists
- TreeSet
- TreeMap
- Stream API
- Business rule processing
- Report generation
- Ranking systems

Java provides two mechanisms for ordering:

1. Comparable (Natural Ordering)
2. Comparator (Custom Ordering)

Understanding the difference is critical.

---

# 2. Comparable Interface

Package:

```
java.lang
```

Method:

```java
int compareTo(T o);
```

Used to define:

> Natural ordering of objects.

---

## 2.1 How compareTo Works

Returns:

| Return Value | Meaning       |
| ------------ | ------------- |
| Negative     | this < other  |
| Zero         | this == other |
| Positive     | this > other  |

---

## 2.2 Example

```java
class Employee implements Comparable<Employee> {
    @Override
    public int compareTo(Employee other) {
        return this.salary - other.salary;
    }
}
```

Now sorting happens by salary by default.

---

## 2.3 When to Use Comparable

✔ Default natural order  
✔ Domain-level identity ordering  
✔ When class has ONE primary sorting rule

Example:

- String (alphabetical)
- Integer (numeric)
- Date (chronological)

---

# 3. Comparator Interface

Package:

```
java.util
```

Method:

```java
int compare(T o1, T o2);
```

Used to define:

> Custom ordering logic.

---

## 3.1 Example

```java
Comparator<Employee> byName =
    (e1, e2) -> e1.getName().compareTo(e2.getName());
```

---

## 3.2 When to Use Comparator

✔ Multiple sorting strategies  
✔ External sorting logic  
✔ Sorting third-party classes  
✔ Avoid modifying original class

---

# 4. Key Differences

| Feature              | Comparable   | Comparator    |
| -------------------- | ------------ | ------------- |
| Package              | java.lang    | java.util     |
| Method               | compareTo()  | compare()     |
| Sorting Type         | Natural      | Custom        |
| Location             | Inside class | Outside class |
| Multiple Orders      | No           | Yes           |
| Functional Interface | No           | Yes           |

---

# 5. Sorting APIs

### Collections.sort()

```java
Collections.sort(list);
Collections.sort(list, comparator);
```

### List.sort()

```java
list.sort(comparator);
```

### Stream.sorted()

```java
stream.sorted();
stream.sorted(comparator);
```

---

# 6. TreeSet & TreeMap Behavior

TreeSet & TreeMap use:

- Comparable (if no Comparator provided)
- Comparator (if provided)

If ordering is inconsistent with equals():

Data loss may occur.

Very important interview concept.

---

# 7. compareTo Contract

Must be:

✔ Consistent with equals  
✔ Transitive  
✔ Symmetric  
✔ Anti-symmetric

Violating this breaks sorted collections.

---

# 8. Comparator Utility Methods (Java 8+)

```java
Comparator.comparing(Employee::getSalary)
Comparator.comparing(Employee::getName)
Comparator.thenComparing(...)
Comparator.reversed()
```

Modern and powerful.

---

# Conclusion

Comparable defines default identity ordering.

Comparator defines flexible external ordering.
