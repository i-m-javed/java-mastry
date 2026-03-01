# Thread Interaction – wait(), notify(), notifyAll() & Producer-Consumer

## 1. Why Thread Interaction Is Needed

Synchronization ensures mutual exclusion.

But sometimes threads must:

✔ Wait for a condition  
✔ Signal other threads  
✔ Coordinate execution

This is called:

> Inter-thread communication

---

# 2. The Problem Without Interaction

Consider Producer-Consumer:

- Producer adds data to buffer
- Consumer removes data from buffer

If:

- Consumer runs before producer → No data
- Producer runs when buffer full → Overflow

Threads must coordinate.

---

# 3. wait(), notify(), notifyAll()

These methods belong to:

```
java.lang.Object
```

Not Thread.

Why?

Because communication happens through object monitor.

---

# 4. wait()

```java
object.wait();
```

Effects:

✔ Releases monitor lock  
✔ Moves thread to WAITING  
✔ Waits until notified

Must be called inside synchronized block.

---

# 5. notify()

```java
object.notify();
```

Effects:

✔ Wakes ONE waiting thread  
✔ Does NOT release lock immediately

---

# 6. notifyAll()

```java
object.notifyAll();
```

Effects:

✔ Wakes ALL waiting threads  
✔ Safer when multiple threads waiting

---

# 7. Important Rules

✔ Must call inside synchronized block  
✔ wait() releases lock  
✔ notify() does NOT release lock immediately  
✔ Always use loop around wait

Correct pattern:

```java
synchronized(lock) {
    while(conditionNotMet) {
        lock.wait();
    }
}
```

Never use if().

---

# 8. Why Use notifyAll Instead of notify?

If multiple threads waiting:

- notify() may wake wrong thread
- Condition may still not be satisfied
- System may deadlock

notifyAll() ensures correct thread eventually proceeds.

---

# 9. Thread States During Interaction

| Method        | State                                 |
| ------------- | ------------------------------------- |
| wait()        | WAITING                               |
| wait(timeout) | TIMED_WAITING                         |
| notify()      | Moves to BLOCKED until lock available |

---

# 10. Producer-Consumer Model

Core concurrency example.

Without proper wait/notify:

- Busy waiting
- High CPU usage
- Incorrect results

---

# 11. Interview Questions

1. Difference between wait and sleep?
2. Why wait inside synchronized?
3. Does notify release lock?
4. Why use notifyAll?
5. Why use while instead of if?
6. What state during wait?

---

# 12. Production Insight

Low-level wait/notify is rarely used in enterprise systems.

Instead we use:

- BlockingQueue
- Locks
- Semaphores
- Executors

But understanding wait/notify is mandatory for interviews.

---

# Conclusion

Thread interaction enables:

- Coordination
- Proper sequencing
- Safe resource sharing

It prevents busy waiting and race conditions.
