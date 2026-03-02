# JDBC Transactions – ACID, Commit, Rollback & Isolation Levels

## 1. Why Transactions Matter

In real-world systems:

- Money transfers
- Order processing
- Inventory updates
- Banking systems

Multiple SQL statements must behave as:

> One single logical unit of work.

If one fails → all must fail.

This is Transaction Management.

---

# 2. What is a Transaction?

A transaction is:

> A sequence of SQL operations treated as a single unit.

It must follow ACID properties.

---

# 3. ACID Properties

## A – Atomicity

All operations succeed or none succeed.

## C – Consistency

Database moves from one valid state to another.

## I – Isolation

Transactions should not interfere with each other.

## D – Durability

Once committed, changes are permanent.

---

# 4. Auto-Commit Mode

By default:

```java
connection.setAutoCommit(true);
```

Every SQL statement is automatically committed.

This is dangerous for multi-step operations.

---

# 5. Manual Transaction Management

Disable auto-commit:

```java
connection.setAutoCommit(false);
```

Then:

```java
connection.commit();
connection.rollback();
```

---

# 6. Example: Bank Transfer

Steps:

1. Deduct from Account A
2. Add to Account B
3. Commit

If step 2 fails → rollback

---

# 7. Commit

```java
connection.commit();
```

Makes changes permanent.

---

# 8. Rollback

```java
connection.rollback();
```

Reverts all changes since last commit.

---

# 9. Transaction Isolation Levels

Prevent concurrency problems.

Set using:

```java
connection.setTransactionIsolation(level);
```

---

## Isolation Levels

| Level | Prevents |
|--------|----------|
| READ_UNCOMMITTED | Nothing |
| READ_COMMITTED | Dirty Reads |
| REPEATABLE_READ | Dirty + Non-repeatable |
| SERIALIZABLE | Dirty + Non-repeatable + Phantom |

---

# 10. Concurrency Problems

### Dirty Read
Reading uncommitted data.

### Non-Repeatable Read
Same row read twice → different values.

### Phantom Read
New rows appear during transaction.

---

# 11. Best Practices

✔ Always disable auto-commit for multi-step operations  
✔ Always use try-catch for rollback  
✔ Always close connection properly  
✔ Handle SQLException carefully  

---

# 12. Interview Questions

1. What is ACID?
2. What is auto-commit?
3. When to use rollback?
4. What are isolation levels?
5. What is dirty read?
6. How to handle transaction failure?
7. Difference between commit and rollback?

---

# 13. Production Insight

Improper transaction handling causes:

- Data corruption
- Inconsistent financial records
- Database locks
- System failure

Enterprise systems strictly control transactions.

---

# Conclusion

Transactions ensure:

- Data integrity
- Consistency
- Reliability

They are foundational to enterprise backend systems.