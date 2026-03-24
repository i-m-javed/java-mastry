# Object Class, equals() & hashCode()

## 1. Introduction

Every class in Java implicitly extends:

```java
java.lang.Object
```

The Object class is the root of the Java class hierarchy.

Understanding:

- equals()
- hashCode()
- toString()
- clone()
- finalize()

is critical for:

- Collections
- HashMap/HashSet behavior
- Domain model design
- Production debugging
- Interview success

---

# 2. Important Methods of Object Class

| Method     | Purpose                  |
| ---------- | ------------------------ |
| equals()   | Logical equality         |
| hashCode() | Hash-based collections   |
| toString() | Object representation    |
| getClass() | Runtime class info       |
| clone()    | Object duplication       |
| finalize() | Pre-GC hook (deprecated) |

---

# 3. equals() – Logical Equality

Default implementation:

```java
public boolean equals(Object obj) {
    return (this == obj);
}
```

Default equals() compares:

- Memory address (reference equality)

This is usually WRONG for domain objects.

Example:

```java
User u1 = new User(1, "Javed");
User u2 = new User(1, "Javed");

u1.equals(u2); // false (default behavior)
```

Because references differ.

---

# 4. Overriding equals() Correctly

Rules:

1. Reflexive
2. Symmetric
3. Transitive
4. Consistent
5. x.equals(null) → false

Correct Pattern:

```java
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return id == user.id &&
           Objects.equals(name, user.name);
}
```

---

# 5. hashCode() – Why It Matters

hashCode() is used by:

- HashMap
- HashSet
- Hashtable
- ConcurrentHashMap

Contract:

> If two objects are equal according to equals(),
> they MUST have same hashCode().

If you override equals() and NOT hashCode() → Broken collections behavior.

---

# 6. HashMap Internal Behavior

When inserting into HashMap:

1. hashCode() called
2. Bucket determined
3. equals() used to check duplicates

If hashCode is inconsistent:

- Duplicates occur
- Retrieval fails
- Contains() fails

---

# 7. equals() Without hashCode() – Real Production Bug

Example:

```java
Set<User> users = new HashSet<>();
users.add(new User(1, "Javed"));
users.add(new User(1, "Javed"));
```

If only equals() overridden:
Set may still store duplicates.

---

# 8. Correct hashCode() Implementation

Use:

```java
@Override
public int hashCode() {
    return Objects.hash(id, name);
}
```

Avoid:

- Returning constant
- Using random values
- Using mutable fields

---

# 9. Why Mutable Fields Are Dangerous

If hashCode depends on mutable field:

```java
user.setName("New Name");
```

Hash bucket changes → object becomes unreachable in HashMap.

This is a serious production issue.

---

# 10. toString() – Debugging Tool

Default:

```java
User@1a2b3c
```

Override for readability:

```java
@Override
public String toString() {
    return "User{id=" + id + ", name='" + name + "'}";
}
```

Improves:

- Logs
- Debugging
- Production troubleshooting

---

# 11. getClass() vs instanceof in equals()

Preferred:

```java
getClass() != o.getClass()
```

Better for strict equality.

Using instanceof allows equality across inheritance.

Interview favorite question.

---

# 12. Complete equals() & hashCode() Contract

If:

- equals() true → hashCode must be same

If:

- hashCode same → equals may or may not be true

Never break this rule.

---

# 13. Production Design Insight

Entity objects in:

- Hibernate
- Spring Boot
- REST APIs
- Microservices

Must implement equals/hashCode correctly.

Incorrect implementation causes:

- Cache bugs
- Duplicate entries
- Data inconsistency
- Hard-to-debug issues

---

# Conclusion

equals() and hashCode() are not optional methods.

They define:

- Object identity
- Collection behavior
- Data correctness
- Application stability

Mastering this topic is mandatory for backend engineering roles.
