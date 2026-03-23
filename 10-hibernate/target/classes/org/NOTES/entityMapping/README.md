# 02 - Entity Mapping (postgresql)

---

# 1️⃣ What is Entity Mapping?

Entity mapping defines how:

Java Class → PostgreSQL Table  
Field → Column  
Data Type → SQL Type

Hibernate uses JPA annotations for mapping.

---

# 2️⃣ Basic Mapping Annotations

## @Entity

Marks class as persistent entity.

## @Table

Maps class to table.

```java
@Entity
@Table(name = "students")
```

---

# 3️⃣ Primary Key Mapping

## @Id

Every entity must have a primary key.

---

## ID Generation Strategies (PostgreSQL Important)

### 1️⃣ IDENTITY (Most Common)

Uses PostgreSQL SERIAL / IDENTITY column.

```java
@GeneratedValue(strategy = GenerationType.IDENTITY)
```

✔ Simple  
✔ Auto-increment  
✔ Recommended for small systems

---

### 2️⃣ SEQUENCE (Enterprise Preferred)

PostgreSQL supports sequences natively.

```java
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
@SequenceGenerator(
        name = "student_seq",
        sequenceName = "student_sequence",
        allocationSize = 1
)
```

✔ Better performance  
✔ Recommended in high-load systems

Interview question favorite.

---

# 4️⃣ Column Mapping

## @Column

```java
@Column(name = "student_name", nullable = false, length = 100)
```

Options:

- name
- nullable
- unique
- length
- updatable
- insertable
- columnDefinition

---

# 5️⃣ Data Type Mapping (PostgreSQL Specific)

| Java Type     | PostgreSQL Type |
|---------------|-----------------|
| String        | VARCHAR         |
| int           | INTEGER         |
| long          | BIGINT          |
| boolean       | BOOLEAN         |
| LocalDate     | DATE            |
| LocalDateTime | TIMESTAMP       |
| BigDecimal    | NUMERIC         |
| UUID          | UUID            |

---

# 6️⃣ Enum Mapping

By default:

```java
@Enumerated(EnumType.STRING)
```

Never use ORDINAL in production.

ORDINAL breaks when enum order changes.

---

# 7️⃣ Large Objects

## @Lob

```java

@Lob
private String description;
```

Maps to:

- TEXT
- BYTEA

---

# 8️⃣ Transient Fields

```java

@Transient
private int tempValue;
```

Not stored in DB.

---

# 9️⃣ Embedded Objects

Used for value objects.

```java

@Embedded
private Address address;
```

Address fields merged into table.

---

# 🔟 UUID Mapping (PostgreSQL Powerful Feature)

PostgreSQL supports native UUID type.

```java

@Id
@GeneratedValue
@Column(columnDefinition = "uuid")
private UUID id;
```

Better than numeric IDs in distributed systems.

---

# 1️⃣1️⃣ Best Practices

✔ Always use EnumType.STRING  
✔ Prefer SEQUENCE for large systems  
✔ Avoid columnDefinition unless required  
✔ Use LocalDate instead of Date  
✔ Avoid business logic inside entity  
✔ Keep entities pure

---

# 1️⃣2️⃣ Interview Questions

Q: Difference between IDENTITY and SEQUENCE?  
Q: Why not use EnumType.ORDINAL?  
Q: What is allocationSize?  
Q: What happens if nullable=false?  
Q: How does Hibernate map LocalDate?  
Q: What is @Transient?  
Q: How to map UUID in PostgreSQL?

---

# 📌 Summary

Entity mapping is foundation of Hibernate.

Correct mapping ensures:
✔ Performance  
✔ Data integrity  
✔ Clean architecture  
✔ Scalability
