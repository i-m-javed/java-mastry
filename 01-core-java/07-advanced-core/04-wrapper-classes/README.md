# Wrapper Classes in Java

## 1. Why Wrapper Classes Exist

Java is not a purely object-oriented language because it supports primitive data types.

However, the Java ecosystem (Collections, Generics, Reflection, Frameworks, Streams, JDBC, Hibernate) operates on **objects only**.

Wrapper classes exist to bridge primitives into the object world.

Without wrapper classes:

- Generics would not work
- Collections would not store primitives
- Frameworks could not represent nullable numeric values
- Metadata APIs could not treat numbers as objects

---

## 2. Primitive vs Wrapper – Memory & Architecture Perspective

### Primitive

- Stored in stack (for local variables)
- Holds raw value
- Faster access
- No methods
- Cannot be null

Example:

```java
int x = 10;
```

### Wrapper Object

- Stored in heap
- Contains primitive value inside object
- Has methods and metadata
- Can be null
- Participates in OOP ecosystem

Example:

```java
Integer x = 10;
```

Internally:

```java
public final class Integer extends Number implements Comparable<Integer>
```

Important:

- Wrapper classes are **final**
- They are **immutable**

---

## 3. Complete Primitive → Wrapper Mapping

| Primitive | Wrapper   |
| --------- | --------- |
| byte      | Byte      |
| short     | Short     |
| int       | Integer   |
| long      | Long      |
| float     | Float     |
| double    | Double    |
| char      | Character |
| boolean   | Boolean   |

All reside in `java.lang`.

---

## 4. Immutability – Critical Concept

Wrapper classes are immutable.

```java
Integer a = 10;
a = a + 5;
```

This does NOT modify the object.
It creates a new object.

Why immutable?

- Thread safety
- Cache safety
- Security
- Predictable behavior

---

## 5. Integer Caching (Very Important Interview Topic)

Java caches Integer objects in range:

```
-128 to 127
```

```java
Integer a = 100;
Integer b = 100;
System.out.println(a == b); // true

Integer x = 200;
Integer y = 200;
System.out.println(x == y); // false
```

Reason:

- Small values reused from cache
- Large values create new objects

Interview Twist:
This applies to:

- Byte
- Short
- Integer
- Long
- Character (0 to 127)

---

## 6. == vs equals()

### ==

- Compares reference (memory address)
- Unsafe for wrapper comparison

### equals()

- Compares value
- Always use for wrapper comparison

---

## 7. AutoBoxing & AutoUnboxing (Preview)

AutoBoxing:

```java
Integer x = 10;
```

AutoUnboxing:

```java
int y = x;
```

Compiler internally converts to:

```java
Integer.valueOf(10);
x.intValue();
```

---

## 8. NullPointerException Trap (Production Risk)

```java
Integer x = null;
int y = x;  // Runtime NPE
```

Auto-unboxing tries calling:

```
x.intValue()
```

Since x is null → NPE.

This is a very common real-world bug in enterprise applications.

---

## 9. Performance Implications

Wrapper usage causes:

- Heap allocation
- Garbage creation
- Slower arithmetic
- Extra memory overhead

Never use wrappers in:

- High-performance loops
- Intensive calculations
- Algorithm-heavy systems

---

## 10. Real-World Usage

Used in:

- Hibernate (nullable DB columns)
- Spring MVC DTOs
- JSON mapping
- REST APIs
- Collections framework
- Stream API
- Optional values

Example:

```java
private Integer age;  // Can represent NULL in DB
```

Primitive cannot represent null.

---

## 11. Edge Cases Interviewers Ask

1. Why is Integer immutable?
2. Why does Integer use caching?
3. Why does `Integer a = 128; Integer b = 128;` fail with `==`?
4. Can wrapper classes be synchronized?
5. Why are wrapper classes final?
6. What happens internally during auto-unboxing?
7. Why are wrapper classes bad for performance loops?

---

## 12. When to Use What

Use primitive when:

- Performance critical
- Value always exists
- Internal computation

Use wrapper when:

- Working with Collections
- Generics
- Frameworks
- Nullable values
- API contracts

---

## 13. Production Design Insight

In enterprise systems:

Bad Design:

```java
int quantity;  // Cannot distinguish between 0 and NULL
```

Better:

```java
Integer quantity;  // NULL means not provided
```

Wrapper choice often reflects domain modeling maturity.

---

## Conclusion

Wrapper classes are not a beginner topic.

They represent:

- Java’s hybrid nature
- Memory model understanding
- Performance trade-offs
- Framework compatibility
- Production risk awareness

Mastering wrapper classes demonstrates strong Java fundamentals required for backend engineering roles.
