# JDBC – Java Database Connectivity

## 1. Why JDBC Matters

Almost every backend application interacts with a database.

JDBC provides:

✔ Database connectivity  
✔ SQL execution  
✔ Data retrieval  
✔ Transaction management  
✔ CRUD operations

Without JDBC, Java cannot directly talk to relational databases.

---

# 2. What is JDBC?

JDBC (Java Database Connectivity) is:

> A standard Java API for interacting with relational databases.

It provides:

- Interfaces
- Classes
- Drivers

Located in:

```
java.sql
```

---

# 3. JDBC Architecture

```
Java Application
        ↓
JDBC API
        ↓
JDBC Driver
        ↓
Database
```

The JDBC driver acts as translator between Java and database.

---

# 4. JDBC Driver Types

There are 4 types:

1. Type 1 – JDBC-ODBC Bridge (Deprecated)
2. Type 2 – Native API
3. Type 3 – Network Protocol
4. Type 4 – Thin Driver (Most Common)

Modern systems use:

> Type 4 Driver

Example:

- MySQL Connector/J
- PostgreSQL JDBC Driver

---

# 5. Steps to Connect to Database

### Step 1: Load Driver (Optional in modern JDBC)

```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

### Step 2: Establish Connection

```java
Connection con = DriverManager.getConnection(
    url, username, password
);
```

### Step 3: Create Statement

```java
Statement stmt = con.createStatement();
```

### Step 4: Execute Query

```java
ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
```

### Step 5: Process Result

```java
while(rs.next()) {
    rs.getInt("id");
}
```

### Step 6: Close Resources

Always close in reverse order.

---

# 6. Core JDBC Interfaces

| Interface         | Purpose           |
| ----------------- | ----------------- |
| DriverManager     | Manages drivers   |
| Connection        | Database session  |
| Statement         | Execute SQL       |
| PreparedStatement | Precompiled SQL   |
| CallableStatement | Stored procedures |
| ResultSet         | Query results     |

---

# 7. Statement vs PreparedStatement

### Statement

- Dynamic SQL
- Vulnerable to SQL Injection

### PreparedStatement

- Precompiled
- Parameterized
- Safer
- Better performance

Always prefer PreparedStatement.

---

# 8. ResultSet

ResultSet cursor types:

- Forward-only (default)
- Scrollable

Access methods:

```java
rs.getInt("id");
rs.getString("name");
```

---

# 9. SQLException

Most JDBC operations throw:

```
SQLException
```

Contains:

- Error code
- SQL state
- Vendor-specific details

---

# 10. Transaction Management

By default:

```
Auto-commit = true
```

Each query commits automatically.

For manual transaction:

```java
con.setAutoCommit(false);
con.commit();
con.rollback();
```

Critical for:

- Banking systems
- Financial operations
- Data consistency

---

# 11. Connection Pooling

Creating connection is expensive.

Enterprise systems use:

- HikariCP
- Apache DBCP
- C3P0

Connection pooling improves:

✔ Performance  
✔ Scalability  
✔ Resource management

---

# 12. Interview Questions

1. What is JDBC?
2. Explain JDBC architecture.
3. Statement vs PreparedStatement?
4. What is SQL Injection?
5. What is auto-commit?
6. How to manage transactions?
7. What is connection pooling?

---

# 13. Production Insight

Best practices:

✔ Always use PreparedStatement  
✔ Always close resources  
✔ Use try-with-resources  
✔ Handle transactions carefully  
✔ Use connection pool

Improper JDBC usage causes:

- Memory leaks
- Connection leaks
- Database lock issues
- Performance bottlenecks

---

# Conclusion

JDBC is the foundation of:

- Backend data access
- DAO layer
- Enterprise applications

Understanding JDBC deeply is required before learning:

- ORM (Hibernate)
- Spring Data JPA
- Connection pooling
