# 05 - HQL & Criteria Deep Dive

---

# 1️⃣ What is HQL?

HQL = Hibernate Query Language.

It is:

- Object-oriented
- Works on entities, not tables
- Database-independent

Example:

```
from Student
```

NOT:

```
select * from students
```

---

# 2️⃣ HQL vs SQL

| HQL               | SQL               |
|-------------------|-------------------|
| Works on Entities | Works on Tables   |
| Uses class names  | Uses table names  |
| Portable          | DB specific       |
| Uses properties   | Uses column names |

---

# 3️⃣ Basic HQL Examples

## Fetch All

```
from Student
```

## Where Condition

```
from Student s where s.age > 20
```

## Ordering

```
from Student s order by s.name asc
```

---

# 4️⃣ Parameter Binding (Important)

Never concatenate strings.

Wrong:

```
"from Student where name = '" + name + "'"
```

Correct:

```
from Student where name = :name
```

Then:

```
query.setParameter("name", "Javed");
```

Prevents SQL injection.

---

# 5️⃣ Pagination

```
query.setFirstResult(0);
query.setMaxResults(10);
```

Used for:

- Large datasets
- REST APIs
- Page-based loading

---

# 6️⃣ Aggregation Functions

HQL supports:

- count()
- sum()
- avg()
- min()
- max()

Example:

```
select count(s) from Student s
```

---

# 7️⃣ Projections

Instead of fetching full entity:

```
select s.name from Student s
```

Returns:
List<String>

Better performance when full entity not needed.

---

# 8️⃣ JOIN & JOIN FETCH

## JOIN

```
select s from Student s join s.department d
```

## JOIN FETCH

```
select s from Student s join fetch s.department
```

JOIN FETCH solves N+1.

---

# 9️⃣ Named Queries

Defined at entity level:

```
@NamedQuery(
    name = "Student.findByAge",
    query = "from Student s where s.age > :age"
)
```

Reusable & cleaner.

---

# 🔟 Native Queries

Use when:

- Complex SQL
- PostgreSQL-specific features
- JSONB
- Window functions

Example:

```
session.createNativeQuery("select * from students", Student.class)
```

---

# 1️⃣1️⃣ Criteria API

Type-safe query building.

Avoids string-based queries.

Example:

```
CriteriaBuilder cb = session.getCriteriaBuilder();
CriteriaQuery<Student> cq = cb.createQuery(Student.class);
Root<Student> root = cq.from(Student.class);
cq.select(root);
```

More verbose but safer.

---

# 1️⃣2️⃣ Interview Questions

Q: Difference between HQL and SQL?  
Q: What is JOIN FETCH?  
Q: How to prevent SQL injection in HQL?  
Q: What is pagination?  
Q: When use native query?  
Q: Why use Criteria API?

---
