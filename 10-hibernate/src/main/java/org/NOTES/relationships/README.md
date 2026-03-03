# 04 - Relationships

---

# 1️⃣ Why Relationships Matter

In real-world systems:

- Student has Courses
- Order has Items
- User has Roles
- Employee belongs to Department

Database tables are related using:

- Foreign Keys
- Join tables

Hibernate maps these relationships to Java objects.

---

# 2️⃣ Relationship Types

| Annotation  | Meaning                     |
|-------------|-----------------------------|
| @OneToOne   | One entity relates to one   |
| @OneToMany  | One entity relates to many  |
| @ManyToOne  | Many entities relate to one |
| @ManyToMany | Many-to-many relationship   |

---

# 3️⃣ Owning Side vs Inverse Side

Very important concept.

Owning side:

- Contains foreign key
- Controls relationship

Inverse side:

- Uses mappedBy
- Does not control DB updates

If you misunderstand this:

- Updates won’t persist
- Join table won’t update

Interview favorite.

---

# 4️⃣ @ManyToOne (Most Common)

Example:
Many Students → One Department

Database:
students table contains department_id

Student.java:

```
@ManyToOne
@JoinColumn(name = "department_id")
private Department department;
```

This is owning side.

---

# 5️⃣ @OneToMany

Inverse side:

```
@OneToMany(mappedBy = "department")
private List<Student> students;
```

mappedBy points to field in owning side.

---

# 6️⃣ Cascade Types

Controls what happens to child when parent changes.

Common cascades:

| Cascade | Meaning                    |
|---------|----------------------------|
| PERSIST | Save child automatically   |
| MERGE   | Merge child automatically  |
| REMOVE  | Delete child automatically |
| ALL     | All operations             |

Be careful with REMOVE in OneToMany.

---

# 7️⃣ Fetch Types

Two types:

## EAGER

Loads immediately.

## LAZY

Loads only when accessed.

Default:

- ManyToOne → EAGER
- OneToMany → LAZY

Best practice:
👉 Always prefer LAZY unless necessary.

---

# 8️⃣ N+1 Problem

When loading parent and accessing children lazily:

Hibernate executes:

1 query for parent
N queries for each child

This is N+1 problem.

Solution:

- JOIN FETCH
- Batch fetching
- EntityGraph

Interview must-know.

---

# 9️⃣ @ManyToMany

Requires join table.

Example:
Student ↔ Course

```
@ManyToMany
@JoinTable(
    name = "student_course",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id")
)
```

Be cautious with cascading here.

---

# 🔟 Best Practices

✔ Prefer ManyToOne over OneToMany when possible  
✔ Keep owning side clear  
✔ Avoid bidirectional unless needed  
✔ Avoid CascadeType.ALL blindly  
✔ Prefer LAZY fetching  
✔ Control fetch with JOIN FETCH

---

# 1️⃣1️⃣ Common Interview Questions

Q: What is owning side?  
Q: What does mappedBy mean?  
Q: Default fetch type for ManyToOne?  
Q: What is N+1 problem?  
Q: Difference between LAZY and EAGER?  
Q: Why avoid CascadeType.ALL?  
Q: How to solve N+1?

---


