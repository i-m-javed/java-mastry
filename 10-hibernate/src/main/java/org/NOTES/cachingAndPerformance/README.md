# 06 - Caching & Performance Internals

---

# 1️⃣ Why Caching Matters

Database calls are expensive.

Caching reduces:

- Network overhead
- DB load
- Repeated queries
- Latency

Hibernate provides:

✔ First-Level Cache
✔ Second-Level Cache
✔ Query Cache

---

# 2️⃣ First-Level Cache (Mandatory)

Also called:
👉 Persistence Context

Exists:

- Per Session
- Automatically enabled
- Cannot be disabled

Example:

session.get(Student.class, 1);
session.get(Student.class, 1);

Only ONE SQL executes.

Second call hits cache.

Cleared when:

- session.close()
- session.clear()

---

# 3️⃣ How First-Level Cache Works

Internally:
Hibernate maintains:

Map<EntityKey, Entity>

EntityKey = (EntityName + ID)

Before hitting DB:
Hibernate checks cache first.

---

# 4️⃣ Second-Level Cache (Optional)

Shared across Sessions.

Configured at:
SessionFactory level.

Stores:

- Entities
- Collections

Requires external provider:

- Ehcache
- Caffeine
- Infinispan

Not enabled by default.

---

# 5️⃣ Query Cache

Caches:

- Query result IDs
- Not full entities

Must enable:

- Second-level cache
- Query cache separately

Use carefully.

---

# 6️⃣ Dirty Checking (Internal Mechanism)

Hibernate tracks entity state snapshot.

On flush:

- Compares current state
- With original snapshot
- Generates UPDATE only if changed

No manual update required.

---

# 7️⃣ Flush Behavior

Flush triggers:

- Before transaction commit
- Before query execution (sometimes)

Flush does NOT commit.

Flush modes:

- AUTO (default)
- COMMIT
- MANUAL

---

# 8️⃣ JDBC Batching (Important)

Instead of:

Insert 1 row → 1 DB call  
Insert 2 row → 1 DB call  
...

Hibernate can batch:

Insert 50 rows → 1 DB roundtrip

Enable:

hibernate.jdbc.batch_size=20

Improves performance significantly.

---

# 9️⃣ allocationSize (Sequence Optimization)

For SEQUENCE strategy:

allocationSize controls:
How many IDs Hibernate pre-fetches.

Example:

allocationSize=50

Hibernate fetches 50 IDs in one go.

Reduces DB sequence calls.

Very important in high-traffic systems.

---

# 🔟 N+1 Performance Tuning

Avoid:

- EAGER fetch on collections
- Blind JOIN FETCH everywhere

Use:

- DTO projections
- Batch size
- EntityGraph
- Proper indexing

---

# 1️⃣1️⃣ Indexing Strategy (PostgreSQL)

Always index:

- Foreign keys
- Frequently filtered columns
- Join columns

Hibernate does NOT create optimal indexes automatically.

DB-level tuning required.

---

# First level cache Demo

```java
session.beginTransaction();

Student s1 = session.get(Student.class, 1L);
Student s2 = session.get(Student.class, 1L);

System.out.

println(s1 ==s2); // true

session.

getTransaction().

commit();
```

only one SQL execute

# Dirty checking Demo

```java

session.beginTransaction();

Student student = session.get(Student.class, 1L);
student.

setName("Updated Name");

session.

getTransaction().

commit();
```

No update() call needed.
Hibernate auto-generates UPDATE.

# Enable JDBC Batching (hibernate.cfg.xml)

```java

<property name="hibernate.jdbc.batch_size">20</property>
<property name="hibernate.order_inserts">true</property>
<property name="hibernate.order_updates">true</property>
```

# Sequence Optimization example

```java
@SequenceGenerator(
        name = "student_seq",
        sequenceName = "student_sequence",
        allocationSize = 50
)
```