# 01 - Hibernate Fundamentals

---

# 1️⃣ What is Hibernate?

Hibernate is an ORM (Object Relational Mapping) framework for Java.

It maps:

Java Objects ↔ Database Tables

Without writing JDBC boilerplate.

---

# 2️⃣ Why Hibernate Exists

Problem with JDBC:

❌ Too much boilerplate  
❌ Manual ResultSet mapping  
❌ Error-prone SQL handling  
❌ Hard to maintain  
❌ No caching  
❌ Tight coupling

Hibernate solves:

✔ Automatic mapping  
✔ Object-based queries  
✔ Caching  
✔ Transaction management  
✔ Lazy loading  
✔ Relationship management

---

# 3️⃣ What is ORM?

ORM = Object Relational Mapping

Maps:

Class → Table  
Field → Column  
Object → Row

Example:

```
class Student
```

Maps to:

```
STUDENT table
```

---

# 4️⃣ Hibernate Architecture

Core components:

- Configuration
- SessionFactory
- Session
- Transaction
- Query

Flow:

Application
↓
SessionFactory
↓
Session
↓
Database

---

# 5️⃣ Important Interfaces

## Configuration

Reads hibernate.cfg.xml

## SessionFactory

Heavy object

- Created once
- Thread-safe
- Represents database

## Session

- Not thread-safe
- Represents connection
- Used for CRUD

## Transaction

Ensures atomicity

---

# 6️⃣ Hibernate vs JPA

Hibernate = Implementation  
JPA = Specification

In real-world:
We code against JPA
Hibernate runs underneath.

---

# 7️⃣ Hibernate Core Concepts

✔ Entity  
✔ Persistence Context  
✔ First-level cache  
✔ Dirty checking  
✔ Lazy loading  
✔ Flush  
✔ Cascade  
✔ Fetch types

---

# 8️⃣ Entity Lifecycle States

1. Transient
2. Persistent
3. Detached
4. Removed

Interview favorite.

---

# 9️⃣ Why Hibernate is Powerful

✔ Reduces boilerplate  
✔ Manages relationships  
✔ Supports caching  
✔ Optimizes SQL  
✔ Works with Spring Boot

---

# 🔟 Common Interview Questions

Q: What is SessionFactory?  
Q: Difference between Session and EntityManager?  
Q: What is persistence context?  
Q: What is dirty checking?  
Q: What is lazy loading?  
Q: Difference between save() and persist()?  
Q: First-level vs Second-level cache?

---

# 📌 Summary

Hibernate is not just a CRUD tool.

It is:

✔ An ORM engine  
✔ A persistence abstraction  
✔ A caching layer  
✔ A transaction manager  
✔ A performance optimizer
