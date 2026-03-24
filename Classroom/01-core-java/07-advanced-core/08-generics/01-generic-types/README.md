# Generic Types in Java

## 1. Introduction

Generics were introduced in Java 5 to provide:

✔ Compile-time type safety  
✔ Elimination of explicit casting  
✔ Reusable type-safe components  
✔ Stronger API contracts

Before Generics:

```java
List list = new ArrayList();
list.add("Java");
String s = (String) list.get(0);  // Explicit casting
```

After Generics:

```java
List<String> list = new ArrayList<>();
String s = list.get(0);  // No casting
```

---

# 2. Why Generics Were Introduced

Problems before Generics:

- Runtime ClassCastException
- Unsafe collections
- Weak type guarantees
- Hard-to-debug production errors

Generics shift errors from:
Runtime → Compile-time

This is a massive improvement in safety.

---

# 3. Generic Class

Basic Syntax:

```java
class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}
```

T is called:

> Type Parameter

---

# 4. Generic Type Naming Conventions

| Symbol | Meaning     |
| ------ | ----------- |
| T      | Type        |
| E      | Element     |
| K      | Key         |
| V      | Value       |
| N      | Number      |
| R      | Return Type |

---

# 5. Multiple Type Parameters

```java
class Pair<K, V> {
    private K key;
    private V value;
}
```

Used heavily in:

- Map
- Framework APIs

---

# 6. Generic Methods

Generics can be declared at method level:

```java
public <T> void print(T value) {
    System.out.println(value);
}
```

Important:
`<T>` before return type defines type parameter.

---

# 7. Bounded Type Parameters

Restrict generic type:

```java
class NumberBox<T extends Number> {
}
```

Now T must be:

- Integer
- Double
- Float
- etc.

---

# 8. Why Generics Are Compile-Time Only (Type Erasure)

Java implements Generics using:

> Type Erasure

At runtime:

```java
List<String>
```

Becomes:

```java
List
```

Type parameter information is removed.

Important consequences:

- Cannot use primitive types
- Cannot create new T()
- Cannot use instanceof with generic type
- Cannot create generic arrays

---

# 9. Generic Restrictions

❌ Cannot instantiate generic type:

```java
new T(); // Not allowed
```

❌ Cannot create generic array:

```java
new T[10]; // Not allowed
```

❌ Cannot use primitive types:

```java
List<int> // Not allowed
```

---

# 10. Raw Types (Legacy Compatibility)

Raw type:

```java
List list = new ArrayList();
```

This disables type safety.

Used for backward compatibility with pre-Java 5 code.

---

# 11. Benefits of Generics

✔ Type safety  
✔ Eliminates casting  
✔ Better readability  
✔ Stronger APIs  
✔ Reduces runtime errors

---

# 12. Production Design Insight

Generics are foundation of:

- Collections Framework
- Spring Framework
- Hibernate
- REST DTO models
- Repository interfaces
- Functional programming APIs

Without generics, enterprise Java would not scale safely.

---

# Conclusion

Generics are not just syntax.

They are:

- Compile-time safety mechanism
- API contract enforcer
- Foundation of modern Java frameworks


