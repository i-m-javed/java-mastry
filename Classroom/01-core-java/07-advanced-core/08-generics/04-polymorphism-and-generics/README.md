# Polymorphism and Generics

## 1. The Core Confusion

We know:

```java
String extends Object
```

So logically:

```java
List<String> should extend List<Object>
```

But it does NOT.

Why?

Because Generics in Java are **Invariant**.

---

# 2. Invariance – Core Rule

Even if:

```
A is subtype of B
```

It does NOT mean:

```
List<A> is subtype of List<B>
```

Example:

```java
List<String> strings = new ArrayList<>();
List<Object> objects = strings; // Compilation Error
```

---

# 3. Why Invariance Exists (Type Safety)

If this were allowed:

```java
List<String> strings = new ArrayList<>();
List<Object> objects = strings;

objects.add(100);  // Allowed
String s = strings.get(0); // Runtime crash
```

This breaks type safety.

Therefore Java prevents it at compile time.

---

# 4. Covariance – ? extends

If you want to say:

> A list of some type that extends Number

Use:

```java
List<? extends Number>
```

Example:

```java
List<Integer> intList = new ArrayList<>();
List<? extends Number> numbers = intList;
```

But:

You cannot add elements:

```java
numbers.add(10); // Compilation Error
```

Because compiler does not know exact subtype.

---

# 5. Contravariance – ? super

If you want to say:

> A list that can accept Integer or its supertypes

Use:

```java
List<? super Integer>
```

Example:

```java
List<Number> numbers = new ArrayList<>();
List<? super Integer> list = numbers;

list.add(10); // Allowed
```

But reading returns Object.

---

# 6. PECS Principle

PECS =

> Producer Extends  
> Consumer Super

If a structure PRODUCES data:
Use `? extends`

If a structure CONSUMES data:
Use `? super`

---

# 7. Read vs Write Rules

| Type              | Can Read | Can Write |
| ----------------- | -------- | --------- |
| List<T>           | Yes      | Yes       |
| List<? extends T> | Yes      | No        |
| List<? super T>   | Object   | Yes       |

---

# 8. Practical Example

Method that only reads numbers:

```java
public static double sum(List<? extends Number> list)
```

Method that adds integers:

```java
public static void addNumbers(List<? super Integer> list)
```

---

# 9. Relationship to Polymorphism

Generics modify traditional polymorphism.

Normal polymorphism:

```java
Animal a = new Dog();
```

Generics are invariant unless wildcards used.

Wildcards restore controlled polymorphism.

---

# 11. List<?> Meaning

```java
List<?> list
```

Means:

List of unknown type.

You can:

- Read as Object
- Cannot add anything except null

---

# 12. Production Insight

Wildcards are used heavily in:

- Stream API
- Collections API
- Spring Framework
- Functional programming

Understanding this is essential for modern Java.

---

# Conclusion

Polymorphism with Generics introduces:

- Invariance
- Covariance
- Contravariance
- PECS
