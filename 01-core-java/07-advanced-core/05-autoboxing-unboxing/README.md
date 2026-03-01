# Autoboxing & Unboxing in Java

## 1. Introduction

Autoboxing and Unboxing were introduced in Java 5.

They allow automatic conversion between:

- Primitive types → Wrapper objects (Autoboxing)
- Wrapper objects → Primitive types (Unboxing)

This feature improved code readability but introduced hidden performance costs and runtime risks.

Understanding what happens internally is critical for backend engineers.

---

## 2. What is Autoboxing?

Autoboxing = Primitive → Wrapper conversion automatically done by compiler.

Example:

```java
Integer x = 10;
```

Compiler converts it to:

```java
Integer x = Integer.valueOf(10);
```

Important:
- It does NOT call `new Integer()`
- It uses `valueOf()` (which enables caching)

---

## 3. What is Unboxing?

Unboxing = Wrapper → Primitive conversion automatically done by compiler.

Example:

```java
Integer x = 10;
int y = x;
```

Compiler converts to:

```java
int y = x.intValue();
```

---

## 4. Where Autoboxing Happens Automatically

1. Assignments
2. Method arguments
3. Return values
4. Arithmetic operations
5. Ternary operators
6. Comparisons

Example:

```java
Integer a = 5;
Integer b = 10;
Integer sum = a + b;
```

Compiler expands to:

```java
Integer sum = Integer.valueOf(a.intValue() + b.intValue());
```

Hidden unboxing + re-boxing happens.

---

## 5. Performance Impact (Critical)

Autoboxing creates:

- Extra method calls
- Temporary objects
- Heap allocation
- Garbage collection pressure

In tight loops, this causes measurable slowdown.

Example:

```java
Integer sum = 0;
for (int i = 0; i < 1_000_000; i++) {
    sum += i;
}
```

Every iteration:
- Unboxes sum
- Performs addition
- Boxes result again

This creates massive overhead.

---

## 6. NullPointerException Risk (Production Bug)

```java
Integer value = null;
int x = value;  // Runtime crash
```

Compiler generates:
```
value.intValue()
```

If value is null → NPE.

This is one of the most common enterprise bugs.

---

## 7. Comparison Pitfalls

```java
Integer a = 1000;
Integer b = 1000;

System.out.println(a == b); // false
```

But:

```java
System.out.println(a < b);  // true
```

Why?

`<` forces unboxing.

`==` compares references (if both are objects).

---

## 8. Autoboxing in Collections

Collections require objects.

```java
List<Integer> list = new ArrayList<>();
list.add(10);  // autoboxing
```

Compiler generates:
```
list.add(Integer.valueOf(10));
```

---

## 9. Autoboxing in Streams

Example:

```java
List<Integer> numbers = Arrays.asList(1,2,3);
numbers.stream().map(x -> x + 1);
```

Boxing/unboxing happens internally.

Better for performance:

```java
IntStream.range(1, 1000)
```

Primitive streams avoid boxing overhead.

---

## 10. Ternary Operator Trap

```java
Integer a = null;
int result = (a != null) ? a : 0;
```

Safe.

But:

```java
Integer a = null;
Integer b = (a != null) ? a : 0;
```

0 gets boxed.

Mixed types can cause unexpected conversions.

---

## 11. Interview Questions

1. What method does compiler call during autoboxing?
2. Why does `Integer sum = 0; sum += i;` cause performance issues?
3. Can autoboxing cause memory leaks?
4. Why does `<` work but `==` fail with wrappers?
5. What happens internally during unboxing of null?
6. How to avoid boxing in streams?

---

## 12. When to Avoid Autoboxing

Avoid in:

- High-frequency loops
- Performance-sensitive code
- Numeric algorithms
- Financial calculation engines
- Large dataset processing

Use primitives instead.

---

## 13. Production Design Insight

In enterprise backend:

Bad:
```java
Integer total = 0;
for(...) total += value;
```

Better:
```java
int total = 0;
```

Use wrapper only when:
- Null is meaningful
- Required by API
- Working with collections

---

## Conclusion

Autoboxing improves readability but hides:

- Performance cost
- Memory overhead
- NPE risks
- Hidden conversions
