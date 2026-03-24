# DAO Pattern – Data Access Object (Professional JDBC Structure)

## 1. Why DAO Pattern Is Required

Directly writing JDBC code inside:

```
main()
service classes
business logic
```

is BAD design.

Problems:

❌ Tight coupling  
❌ Hard to test  
❌ Hard to maintain  
❌ Poor separation of concerns  
❌ Not scalable

DAO Pattern solves this.

---

# 2. What is DAO?

DAO (Data Access Object) is:

> A design pattern that separates data access logic from business logic.

It abstracts:

- SQL queries
- Connection handling
- ResultSet mapping
- Transaction control

---

# 3. Layered Architecture Concept

```
Controller Layer
        ↓
Service Layer
        ↓
DAO Layer
        ↓
Database
```

DAO belongs to:

```
Persistence Layer
```

---

# 4. DAO Structure

Typical structure:

```
Employee.java        (Model / Entity)
EmployeeDAO.java     (Interface)
EmployeeDAOImpl.java (Implementation)
Main.java            (Client)
```

---

# 5. Responsibilities of DAO

✔ Perform CRUD operations  
✔ Hide SQL queries  
✔ Manage ResultSet mapping  
✔ Handle database exceptions  
✔ Return domain objects

DAO should NOT:

❌ Contain business logic  
❌ Contain UI logic

---

# 6. Benefits of DAO Pattern

✔ Separation of concerns  
✔ Easier testing (Mock DAO)  
✔ Better maintainability  
✔ Cleaner code  
✔ Swappable database implementations

---

# 7. Example DAO Interface

```java
public interface EmployeeDAO {

    void save(Employee employee);

    Employee findById(int id);

    List<Employee> findAll();

    void update(Employee employee);

    void delete(int id);
}
```

---

# 8. DAO Implementation

Contains:

- JDBC code
- PreparedStatement
- ResultSet mapping
- Transaction handling

---

# 9. Interview Questions

1. What is DAO pattern?
2. Why separate DAO from business logic?
3. DAO vs Repository?
4. Where does DAO fit in layered architecture?
5. How does DAO improve maintainability?

---

# 10. Production Insight

In real systems:

- DAO is used with JDBC
- Later replaced by Hibernate / JPA
- Spring uses @Repository annotation
- DAO integrates with connection pooling

Understanding DAO is mandatory before learning:

- Design Patterns
- Spring Framework
- Architecture

---

# Conclusion

DAO Pattern:

- Encapsulates database logic
- Promotes clean architecture
- Improves scalability

It is a foundation of enterprise Java development.
