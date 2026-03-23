# 02 - EntityManager CRUD Deep Dive

---

# 1️⃣ EntityManager = Persistence Context Controller

EntityManager manages:

- Entity lifecycle
- First-level cache
- Dirty checking
- Transactions

Each EntityManager has:
👉 One Persistence Context

---

# 2️⃣ find() vs getReference()

## find()

- Immediately hits database
- Returns null if not found
- Returns fully initialized entity

Example:

```
Student s = em.find(Student.class, 1L);
```

---

## getReference()

- Returns proxy
- Lazy initialization
- Does NOT hit DB immediately
- Throws EntityNotFoundException when accessed if not found

Example:

```
Student s = em.getReference(Student.class, 1L);
```

Interview favorite difference.

---

# 3️⃣ persist() vs merge()

## persist()

- Makes transient entity managed
- Entity must NOT already exist
- Does NOT return anything

```
em.persist(student);
```

---

## merge()

- Works for detached entity
- Copies state into managed entity
- Returns managed instance

```
Student managed = em.merge(detachedStudent);
```

Important:
Always use returned instance.

---

# 4️⃣ remove()

Entity must be managed.

```
Student s = em.find(Student.class, 1L);
em.remove(s);
```

If detached:

- Must merge first.

---

# 5️⃣ detach()

Removes entity from persistence context.

```
em.detach(student);
```

Changes after detach:

- NOT tracked
- No dirty checking

---

# 6️⃣ clear()

Clears entire persistence context.

```
em.clear();
```

All entities become detached.

---

# 7️⃣ flush()

Synchronizes persistence context with DB.

Flush ≠ Commit.

Flush:

- Executes SQL
- But transaction not committed yet

Commit:

- Makes changes permanent

---

# 8️⃣ Identity Guarantee

Inside same persistence context:

```
Student s1 = em.find(Student.class, 1L);
Student s2 = em.find(Student.class, 1L);
```

s1 == s2 → true

JPA guarantees single object per ID per context.

---

# 9️⃣ Detached Entity Pitfall

After closing EntityManager:

```
em.close();
student.setName("New Name");
```

No update occurs.

Entity is detached.

Common production bug.

---

# 🔟 Common Interview Questions

Q: Difference between find and getReference?  
Q: persist vs merge difference?  
Q: What does merge return?  
Q: What is persistence context?  
Q: What happens after detach()?  
Q: What is identity guarantee?  
Q: Flush vs commit difference?

---