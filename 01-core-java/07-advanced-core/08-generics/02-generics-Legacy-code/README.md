# Generics and Legacy Code – Type Erasure, Raw Types & Backward Compatibility

## 1. Why This Topic Exists

Generics were introduced in Java 5.

Before Java 5:
- Collections were non-generic
- Everything stored as Object
- Casting required everywhere

When Generics were introduced:

Java had to maintain backward compatibility.

This decision led to:

- Raw types
- Type erasure
- Bridge methods
- Heap pollution

Understanding this is critical for advanced Java mastery.

---

# 2. Raw Types – What Are They?

Raw type = Generic class used without type parameter.

Example:

```java
List list = new ArrayList();  // Raw type
```

This disables generic type checking.

Equivalent to pre-Java 5 behavior.

---

## Why Raw Types Still Exist?

To support old legacy code.

Example:

Old library:

```java
public List getData();
```

New code must still compile with it.

---

# 3. Type Erasure – Core Concept

Java Generics are implemented using:

> Type Erasure

Meaning:

Generic type information is removed at runtime.

Example:

```java
List<String>
List<Integer>
```

At runtime both become:

```java
List
```

There is no runtime distinction.

---

# 4. Consequences of Type Erasure

Because generics do not exist at runtime:

❌ Cannot create generic array  
❌ Cannot use instanceof with generic type  
❌ Cannot create new T()  
❌ Cannot catch generic exceptions  

Example:

```java
if (obj instanceof List<String>) // Not allowed
```

---

# 5. Heap Pollution

Heap pollution occurs when:

> A variable of parameterized type refers to an object that is not of that parameterized type.

Example:

```java
List<String> list = new ArrayList();
List raw = list;
raw.add(100);  // Compiles

String s = list.get(0); // ClassCastException
```

The compiler warning exists because:

Type safety is broken.

---

# 6. Compiler Warnings

When mixing raw and generic types:

```
Unchecked assignment warning
Unchecked cast warning
```

These warnings are serious.

In production systems:
Always eliminate unchecked warnings.

---

# 7. Bridge Methods (Advanced Topic)

Due to type erasure and polymorphism:

Compiler generates synthetic methods called:

> Bridge Methods

Example:

```java
class Parent<T> {
    T get() { return null; }
}

class Child extends Parent<String> {
    String get() { return "Hello"; }
}
```

At runtime:

Parent's method becomes:

```
Object get()
```

Child overrides:

```
String get()
```

To maintain polymorphism:
Compiler creates bridge method:

```
Object get() { return get(); }
```

This preserves method overriding after erasure.

Interview-level topic.

---

# 8. Why Java Chose Type Erasure

Advantages:

✔ Backward compatibility  
✔ No runtime overhead  
✔ No JVM changes required  

Disadvantages:

❌ Limited runtime generic info  
❌ Certain restrictions  
❌ Confusing errors  

---

# 9. Best Practices

✔ Avoid raw types  
✔ Avoid unchecked warnings  
✔ Use @SuppressWarnings carefully  
✔ Never mix raw and generic collections  
✔ Prefer fully parameterized types  

---

# 10. Interview Questions

1. What is type erasure?
2. Why do raw types exist?
3. What is heap pollution?
4. What is a bridge method?
5. Why can’t we use instanceof with generics?
6. What happens to generic types at runtime?
7. Why Java didn’t use reified generics?

---

# 11. Production Insight

Mixing raw and generic types in enterprise systems causes:

- Random ClassCastException
- Hard-to-debug runtime failures
- Data corruption

Modern Java code should NEVER rely on raw types.

---

# Conclusion

Generics and legacy compatibility reveal:

- Java’s design philosophy
- Trade-offs between safety and compatibility
- Why certain generic restrictions exist

Understanding type erasure separates average developers from expert-level Java engineers.