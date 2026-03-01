# Thread States – Lifecycle & State Transitions

## 1. Why Thread States Matter

Understanding thread states is critical for:

✔ Debugging concurrency issues  
✔ Diagnosing deadlocks  
✔ Analyzing thread dumps  
✔ Performance tuning  
✔ Interview questions

Every Java thread goes through a lifecycle.

---

# 2. Official Thread States (java.lang.Thread.State)

Java defines 6 states:

1. NEW
2. RUNNABLE
3. BLOCKED
4. WAITING
5. TIMED_WAITING
6. TERMINATED

These are observable via:

```java
thread.getState()
```

---

# 3. NEW State

A thread is in NEW state when:

- Thread object is created
- start() has NOT been called

Example:

```java
Thread t = new Thread(task);
System.out.println(t.getState()); // NEW
```

---

# 4. RUNNABLE State

After calling start():

```
NEW → RUNNABLE
```

RUNNABLE includes:

- Ready to run
- Running

Important:

Java does not differentiate between "ready" and "running".

Both are considered RUNNABLE.

---

# 5. BLOCKED State

A thread enters BLOCKED when:

- It tries to acquire a lock
- Another thread already holds that lock

Example:

```java
synchronized(lock) { }
```

If lock unavailable → BLOCKED.

---

# 6. WAITING State

Thread enters WAITING when:

- wait()
- join()
- LockSupport.park()

Thread waits indefinitely until notified.

---

# 7. TIMED_WAITING State

Thread enters TIMED_WAITING when:

- sleep()
- wait(timeout)
- join(timeout)

Thread waits for specified time.

---

# 8. TERMINATED State

After run() completes:

```
RUNNABLE → TERMINATED
```

Thread cannot restart.

---

# 9. Lifecycle Diagram (Conceptual)

```
NEW → RUNNABLE → RUNNING → TERMINATED
          ↓
        BLOCKED
          ↓
       WAITING
          ↓
    TIMED_WAITING
```

State transitions depend on:

- Scheduler
- Lock availability
- wait/notify
- sleep
- join

---

# 10. Important Clarifications

✔ RUNNABLE does not mean currently executing  
✔ BLOCKED means waiting for monitor lock  
✔ WAITING means waiting indefinitely  
✔ TIMED_WAITING means waiting with timeout

---

# 11. Debugging Thread State

In real systems:

- Thread dumps show thread states
- Deadlock analysis depends on state understanding
- Monitoring tools rely on state transitions

---

# 12. Interview Questions

1. What are the thread states in Java?
2. Difference between BLOCKED and WAITING?
3. What state after start()?
4. Can TERMINATED thread restart?
5. What causes TIMED_WAITING?
6. What state during sleep()?

---

# 13. Production Insight

Thread states help diagnose:

- Deadlocks
- Starvation
- Performance bottlenecks
- Lock contention
- Thread pool exhaustion

---
