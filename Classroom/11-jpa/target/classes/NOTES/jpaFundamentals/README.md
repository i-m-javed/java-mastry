# 01 - JPA Fundamentals (EntityManager Deep Dive)

---

# 1️⃣ What is JPA?

JPA = Jakarta Persistence API

It is:

- A specification (NOT an implementation)
- Defines how ORM should work
- Provides standard interfaces

Important:
JPA does NOT implement anything.

Hibernate implements JPA.

---

# 2️⃣ JPA vs Hibernate

| JPA                | Hibernate                |
|--------------------|--------------------------|
| Specification      | Implementation           |
| Uses EntityManager | Uses Session             |
| Portable           | Vendor-specific features |
| Standard API       | Extended features        |

In real projects:
We code against JPA.
Hibernate runs underneath.

---

# 3️⃣ Core JPA Components

- Entity
- EntityManager
- EntityManagerFactory
- Persistence Unit
- Persistence Context
- JPQL
- Criteria API

---

# 4️⃣ EntityManager

Equivalent to Hibernate Session.

Responsibilities:

- Persist entities
- Remove entities
- Find entities
- Create queries
- Manage transactions

Not thread-safe.

---

# 5️⃣ Persistence Unit

Defined in:

META-INF/persistence.xml

Defines:

- Database config
- JPA provider
- Entities
- Properties

---

# 6️⃣ persistence.xml Example

```
<persistence xmlns="https://jakarta.ee/xml/ns/persistence"
             version="3.0">

    <persistence-unit name="jpa-demo">

        <provider>
            org.hibernate.jpa.HibernatePersistenceProvider
        </provider>

        <class>org.jpa.demo.Student</class>

        <properties>
            <property name="jakarta.persistence.jdbc.url"
                      value="jdbc:postgresql://localhost:5432/hibernate"/>

            <property name="jakarta.persistence.jdbc.user"
                      value="postgres"/>

            <property name="jakarta.persistence.jdbc.password"
                      value="root"/>

            <property name="jakarta.persistence.jdbc.driver"
                      value="org.postgresql.Driver"/>

            <property name="hibernate.hbm2ddl.auto" value="update"/>
            <property name="hibernate.show_sql" value="true"/>
        </properties>

    </persistence-unit>

</persistence>
```

---

# 7️⃣ Bootstrapping JPA

```
EntityManagerFactory emf =
    Persistence.createEntityManagerFactory("jpa-demo");

EntityManager em = emf.createEntityManager();
```

---

# 8️⃣ Entity Lifecycle (JPA View)

Same 4 states:

1. Transient
2. Managed
3. Detached
4. Removed

Managed entities are tracked inside Persistence Context.

---

# 9️⃣ persist() vs merge() in JPA

persist():

- Makes entity managed
- Fails if entity already exists

merge():

- Copies state into managed entity
- Returns managed instance

Common interview question.

---

# 🔟 JPQL (JPA Query Language)

Equivalent of HQL.

Works on entity names.

Example:

```
select s from Student s where s.age > :age
```

---

# 1️⃣1️⃣ Flush Modes

Two types:

AUTO (default)
COMMIT

Flush means:
Sync persistence context to DB.

Flush ≠ Commit.

---

# 1️⃣2️⃣ Locking in JPA

Optimistic:
@Version

Pessimistic:
LockModeType.PESSIMISTIC_WRITE

Standardized across providers.

---

# 1️⃣3️⃣ Interview Questions

Q: Difference between EntityManager and Session?  
Q: What is Persistence Context?  
Q: What is persistence.xml?  
Q: persist vs merge difference?  
Q: Flush vs commit?  
Q: What is JPQL?

---
