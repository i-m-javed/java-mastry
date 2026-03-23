# 03 - CRUD Operations & Session

---

# 1️⃣ Hibernate Session Overview

Session represents:

- A connection to the database
- A persistence context
- A first-level cache

Important:
Session is NOT thread-safe.

---

# 2️⃣ Entity Lifecycle States

Hibernate entities exist in 4 states:

1. Transient
    - New object
    - Not associated with session
    - No DB record

2. Persistent
    - Attached to session
    - Managed by Hibernate
    - Changes tracked automatically

3. Detached
    - Was persistent
    - Session closed
    - Not tracked anymore

4. Removed
    - Marked for deletion

Interview favorite question.

---

# 3️⃣ persist() vs save()

## persist()

- JPA standard
- Does NOT return ID
- Makes entity persistent
- Follows JPA lifecycle rules

## save()

- Hibernate-specific
- Returns generated ID
- Legacy method

Preferred:
👉 Use persist() in modern applications.

---

# 4️⃣ merge() vs update()

## update()

- Reattaches detached entity
- Fails if another instance already exists in session

## merge()

- Copies state into managed entity
- Returns managed instance
- Safe for detached objects

Preferred:
👉 Use merge()

Interview trap question.

---

# 5️⃣ remove()

Deletes persistent entity.

Entity must be in persistent state.

If detached:

- Must reattach first.

---

# 6️⃣ get() vs load()

## get()

- Immediately hits DB
- Returns null if not found

## load()

- Returns proxy
- Lazy fetch
- Throws exception if entity not found when accessed

Interview classic.

---

# 7️⃣ First-Level Cache

Every Session has first-level cache.

Meaning:

If you call:

```
session.get(Student.class, 1);
session.get(Student.class, 1);
```

Only ONE SQL query is executed.

Second call uses cache.

Cache exists:

- Until session closes.

---

# 8️⃣ Dirty Checking

Hibernate automatically tracks changes.

Example:

```
Student s = session.get(Student.class, 1);
s.setName("Updated");
```

No explicit update call needed.

On commit:
Hibernate detects change and runs UPDATE.

This is called:

👉 Dirty Checking

---

# 9️⃣ flush()

Flush synchronizes:

Persistence Context → Database

Triggers:

- Before commit
- Before query execution (sometimes)

Does NOT commit transaction.

---

# 🔟 Transaction Boundaries

Correct pattern:

```
Session session = factory.getCurrentSession();

session.beginTransaction();

... operations ...

session.getTransaction().commit();
```

Always wrap operations in transaction.

Even for reads (recommended).

---

# 1️⃣1️⃣ Common Interview Questions

Q: Difference between persist and save?  
Q: merge vs update difference?  
Q: What is first-level cache?  
Q: What is dirty checking?  
Q: When does flush happen?  
Q: get() vs load()?  
Q: What happens if session is closed?

---
