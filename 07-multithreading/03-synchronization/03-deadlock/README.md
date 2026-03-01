# Thread Deadlock – Causes, Detection & Prevention

## 1. What is Deadlock?

Deadlock occurs when:

> Two or more threads are waiting forever for each other to release locks.

No thread progresses.
System appears frozen.

---

## 2. Classic Deadlock Example

Thread-1 holds Lock A → waits for Lock B  
Thread-2 holds Lock B → waits for Lock A

Both are BLOCKED forever.

---

## 3. Necessary Conditions for Deadlock (Coffman Conditions)

All four must be true:

1. Mutual Exclusion
2. Hold and Wait
3. No Preemption
4. Circular Wait

If any one condition is removed → deadlock prevented.

---

## 4. Why Deadlock Is Dangerous

- Threads permanently blocked
- CPU idle but program stuck
- Hard to detect in large systems
- Production outage risk

---

## 5. Deadlock Example Structure

```
Thread 1:
  synchronized(lock1) {
      synchronized(lock2)
  }

Thread 2:
  synchronized(lock2) {
      synchronized(lock1)
  }
```

Lock ordering mismatch causes circular wait.

---

## 6. How to Prevent Deadlock

### ✔ 1. Lock Ordering

Always acquire locks in same order.

Correct:

```
lock1 → lock2
```

Never:

```
Thread1: lock1 → lock2
Thread2: lock2 → lock1
```

---

### ✔ 2. Avoid Nested Locks

Minimize nested synchronized blocks.

---

### ✔ 3. Use Timeout Locks

With ReentrantLock:

```
tryLock(timeout)
```

---

### ✔ 4. Reduce Lock Scope

Use fine-grained locking.

---

## 7. Detecting Deadlock

In real systems:

- Thread dump analysis
- jstack
- VisualVM
- JVM deadlock detection

---

## 8. Deadlock vs Starvation

| Deadlock        | Starvation             |
| --------------- | ---------------------- |
| Circular wait   | Thread never gets CPU  |
| Permanent block | Resource never granted |
| Mutual waiting  | Priority issue         |

---

## 9. Interview Questions

1. What is deadlock?
2. What are Coffman conditions?
3. How to prevent deadlock?
4. Difference between deadlock and starvation?
5. Can synchronized prevent deadlock?
6. How to detect deadlock in production?

---

## 10. Production Insight

Deadlocks commonly occur in:

- Database transactions
- Nested synchronized blocks
- Improper lock ordering
- Distributed systems

Enterprise-grade systems enforce strict lock ordering rules.

---

## Conclusion

Deadlock is a concurrency failure caused by circular lock dependency.

Prevention requires:

- Consistent lock ordering
- Reduced nesting
- Proper lock design
