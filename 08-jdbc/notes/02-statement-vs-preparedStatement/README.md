# Statement vs PreparedStatement

## 1. Why This Topic Is Critical

This is one of the most asked JDBC interview questions.

Understanding the difference impacts:

✔ Security (SQL Injection prevention)  
✔ Performance (Query precompilation)  
✔ Maintainability  
✔ Production-grade backend design

---

# 2. Statement

Statement executes dynamic SQL strings.

Example:

```java
Statement stmt = connection.createStatement();
ResultSet rs = stmt.executeQuery(
    "SELECT * FROM users WHERE username = '" + userInput + "'"
);
```

---

## 2.1 Problems with Statement

❌ Vulnerable to SQL Injection  
❌ Query compiled every time  
❌ Harder to maintain  
❌ Poor readability

---

# 3. SQL Injection Problem

Suppose user enters:

```
' OR '1'='1
```

Query becomes:

```sql
SELECT * FROM users WHERE username = '' OR '1'='1'
```

This returns ALL users.

This is SQL Injection.

Statement allows malicious input to alter query structure.

---

# 4. PreparedStatement

PreparedStatement uses parameterized queries.

Example:

```java
PreparedStatement ps =
    connection.prepareStatement(
        "SELECT * FROM users WHERE username = ?"
    );

ps.setString(1, userInput);
```

---

## 4.1 Why PreparedStatement Is Safe

- SQL structure is fixed
- Parameters are bound separately
- Input cannot alter query structure
- Prevents SQL Injection

---

# 5. Performance Advantage

Statement:

- Query parsed and compiled every execution

PreparedStatement:

- Query compiled once
- Reused multiple times
- Better performance

Especially useful in:

- Batch processing
- Repeated inserts/updates

---

# 6. Code Comparison

| Feature           | Statement  | PreparedStatement |
| ----------------- | ---------- | ----------------- |
| SQL Injection     | Vulnerable | Safe              |
| Precompilation    | No         | Yes               |
| Parameter binding | No         | Yes               |
| Performance       | Lower      | Higher            |
| Recommended       | ❌ No      | ✔ Yes             |

---

# 7. When to Use Statement?

Rare cases:

✔ DDL queries (CREATE TABLE)  
✔ Static SQL with no user input

Otherwise:

Always use PreparedStatement.

---

# 8. Common Interview Questions

1. Difference between Statement and PreparedStatement?
2. What is SQL Injection?
3. How does PreparedStatement prevent SQL Injection?
4. Is PreparedStatement faster?
5. Can PreparedStatement be reused?
6. What happens internally during precompilation?

---

# 9. Production Best Practices

✔ Always use PreparedStatement  
✔ Never concatenate user input  
✔ Use try-with-resources  
✔ Validate input at application level  
✔ Use connection pooling

---

# 10. Internal Working (Advanced Insight)

PreparedStatement:

1. SQL sent to database
2. Database compiles query
3. Execution plan cached
4. Parameters bound at execution time

This reduces parsing overhead.

---

# Conclusion

PreparedStatement is:

- Secure
- Efficient
- Maintainable
- Industry standard
