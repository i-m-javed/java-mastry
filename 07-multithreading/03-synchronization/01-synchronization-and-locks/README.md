# Synchronization & Locks – Preventing Race Conditions

## 1. Why Synchronization Is Needed

When multiple threads access shared mutable data:

```
Race Condition occurs.
```

Race Condition means:

> Final result depends on unpredictable thread execution order.

Example:

```
count++
```

This is NOT atomic.

It internally performs:

1. Read
2. Modify
3. Write

If two threads execute simultaneously → incorrect result.

---

# 2. What is Synchronization?

Synchronization ensures:

✔ Only one thread accesses critical section at a time  
✔ Data consistency  
✔ Mutual exclusion

Keyword:

```
synchronized
```

---

# 3. Critical Section

Critical Section is:

> Code block accessing shared mutable resource.

Example:

```java
synchronized(this) {
    count++;
}
```

---

# 4. How synchronized Works

Every object in Java has:

> An intrinsic monitor lock

When a thread enters:

```
synchronized(object)
```

It must acquire object's monitor lock.

If lock unavailable → thread goes to BLOCKED state.

---

# 5. Ways to Synchronize

## 5.1 Synchronized Method

```java
public synchronized void increment() { }
```

Locks:

```
this
```

---

## 5.2 Synchronized Block

```java
synchronized(lockObject) { }
```

Better control.

Preferred in production.

---

## 5.3 Static Synchronization

```java
public static synchronized void method() { }
```

Locks:

```
Class object
```

---

# 6. Object Lock vs Class Lock

| Type            | Lock Target  |
| --------------- | ------------ |
| Instance method | this         |
| Static method   | Class object |
| Block           | Given object |

Understanding lock target is critical.

---

# 7. Lock Contention

When many threads compete for same lock:

- Performance degrades
- Threads enter BLOCKED state
- Throughput reduces

---

# 8. Reentrant Locking

Java synchronized is:

> Reentrant

If thread already holds lock, it can re-enter synchronized block.

---

# 9. Problems with Over-Synchronization

❌ Performance bottleneck  
❌ Thread starvation  
❌ Increased blocking

Always minimize synchronized scope.

---

# 10. What synchronized Does NOT Do

❌ Does not prevent deadlock  
❌ Does not guarantee fairness  
❌ Does not handle inter-thread communication automatically

---

# 11. Interview Questions

1. What is race condition?
2. How does synchronized work internally?
3. What object is locked in synchronized method?
4. Difference between static and instance synchronization?
5. What state if lock unavailable?
6. Is synchronized reentrant?

---

# 12. Production Insight

In enterprise systems:

- Over-synchronization causes scalability issues.
- Lock granularity matters.
- Fine-grained locking preferred.
- Alternatives like ReentrantLock exist.

Synchronization is powerful but must be used carefully.

---

# Conclusion

Synchronization provides:

- Mutual exclusion
- Data consistency
- Thread safety

It is foundation before learning:

- wait/notify
- Deadlock
- Advanced locks
- Concurrent utilities
