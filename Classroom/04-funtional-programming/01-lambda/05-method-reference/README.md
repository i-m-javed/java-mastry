# Method Reference

## 1. Introduction

Method Reference is a shorthand notation of Lambda expressions.

If a lambda only calls an existing method, we can replace it with a method reference.

Lambda:

```java
x -> System.out.println(x)
```

Method Reference:

```java
System.out::println
```

Cleaner. More readable. Production-preferred.

---

# 2. Why Method Reference Exists

Lambdas reduce verbosity.

Method references reduce it further.

They improve:

✔ Readability  
✔ Intent clarity  
✔ Functional composition  
✔ Clean API design

---

# 3. Syntax

General format:

```java
ClassName::methodName
```

or

```java
objectReference::methodName
```

---

# 4. Types of Method References

There are FOUR types:

---

## 1️⃣ Static Method Reference

```java
ClassName::staticMethod
```

Example:

```java
Integer::parseInt
```

Equivalent lambda:

```java
s -> Integer.parseInt(s)
```

---

## 2️⃣ Instance Method of Particular Object

```java
objectReference::instanceMethod
```

Example:

```java
printer::print
```

Equivalent lambda:

```java
msg -> printer.print(msg)
```

---

## 3️⃣ Instance Method of Arbitrary Object (Most Confusing)

```java
ClassName::instanceMethod
```

Example:

```java
String::toUpperCase
```

Equivalent lambda:

```java
s -> s.toUpperCase()
```

This works because:

First parameter becomes the target object.

---

## 4️⃣ Constructor Reference

```java
ClassName::new
```

Example:

```java
Supplier<List<String>> supplier = ArrayList::new;
```

Equivalent lambda:

```java
() -> new ArrayList<>()
```

---

# 5. When to Use Method Reference

Use when:

✔ Lambda only calls existing method  
✔ Improves readability  
✔ No additional logic required

Avoid when:

❌ Additional transformation needed  
❌ Complex block logic exists

---

# 6. How It Works Internally

Method reference is syntactic sugar over lambda.

Compiler performs:

> Target typing resolution

It matches method signature to functional interface method.

---

# 7. Real-World Usage

Common in:

- Stream API
- Sorting
- Collectors
- Mapping
- Filtering
- Logging

Example:

```java
list.forEach(System.out::println);
```

---

# 8. Method Reference vs Lambda

| Lambda                   | Method Reference    |
| ------------------------ | ------------------- |
| x -> x.toUpperCase()     | String::toUpperCase |
| () -> new ArrayList<>()  | ArrayList::new      |
| s -> Integer.parseInt(s) | Integer::parseInt   |

Method reference is cleaner when applicable.

---
