# Mixing Generic and Non-Generic Collections

## 1. Introduction

Mixing generic and non-generic (raw) collections is one of the most dangerous patterns in Java.

It compiles.
It gives warnings.
It fails at runtime.

This topic is critical for:

- Legacy system maintenance
- Large enterprise codebases
- Framework integration
- Avoiding heap pollution

---

# 2. What Does "Mixing" Mean?

Example:

```java
List<String> typedList = new ArrayList<>();
List rawList = typedList;
```

Here:

- typedList is generic
- rawList is non-generic

They reference the same object.

This breaks type safety.

---

# 3. Why This Is Dangerous

Generic types provide compile-time guarantees.

Raw types remove those guarantees.

Example:

```java
List<String> list = new ArrayList<>();
List raw = list;

raw.add(100);  // Compiles
String value = list.get(0); // Runtime failure
```

This leads to:

```
ClassCastException
```

---

# 4. Heap Pollution (Deep Explanation)

Heap pollution occurs when:

> A variable of parameterized type refers to an object that is not of that parameterized type.

In memory:

The List actually contains:

- String
- Integer

But compiler assumes:
Only String exists.

This mismatch causes runtime crash.

---

# 5. Mixing in Method Parameters

Example:

```java
public void process(List list) {
    list.add(100);
}
```

If caller passes:

```java
List<String> stringList = new ArrayList<>();
process(stringList);
```

The method corrupts the list.

This is extremely dangerous in layered systems.

---

# 6. @SuppressWarnings – Misuse

Developers sometimes do:

```java
@SuppressWarnings("unchecked")
```

This hides warnings.

But does NOT fix problem.

In production:
Warnings must be eliminated, not suppressed blindly.

---

# 7. Safe Legacy Integration Strategy

When interacting with legacy APIs:

✔ Immediately convert raw type to parameterized type  
✔ Validate element types  
✔ Avoid passing generic collections into raw methods

Example:

```java
List<?> safeList = legacyMethod();
```

---

# 8. Why Java Allows This

Because of:

Type Erasure + Backward Compatibility

Java could not break old libraries.

So raw types were retained.

---

# 9. Real Production Risk

Mixing generics and raw types can cause:

- Random ClassCastException
- Data corruption
- Runtime crashes
- Hard-to-debug failures

Especially dangerous in:

- DAO layers
- Utility libraries
- Reflection-based frameworks

---

# 10. Best Practices

✔ Never assign parameterized type to raw reference  
✔ Never use raw collections  
✔ Fix compiler warnings  
✔ Prefer fully parameterized types  
✔ Use bounded wildcards when necessary

---

# Conclusion

Mixing generic and non-generic collections:

- Compiles successfully
- Breaks type safety
- Introduces runtime instability
