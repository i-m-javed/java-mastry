# Preventing Thread Execution – Sleep, Yield, Join & Interrupt

## 1. What Does “Preventing Thread Execution” Mean?

Preventing execution means:

> Temporarily stopping or pausing a thread from running.

This is NOT killing the thread.

Instead, we are controlling:

- When it runs
- How long it pauses
- Whether it waits for other threads

This is critical in:

✔ Coordination  
✔ Resource control  
✔ Rate limiting  
✔ Thread communication  

---

# 2. sleep()

```java
Thread.sleep(milliseconds);
```

## What It Does:

- Moves thread to TIMED_WAITING
- Pauses execution for given time
- Does NOT release locks

Important:

- Static method
- Always affects current thread

---

## Interview Trap:

```
thread.sleep(1000);
```

Still sleeps current thread — not the thread object.

---

# 3. yield()

```java
Thread.yield();
```

## What It Does:

- Suggests scheduler to pause current thread
- Gives other threads equal priority chance

Important:

- It is only a hint
- Scheduler may ignore it

Used rarely in production.

---

# 4. join()

```java
thread.join();
```

## What It Does:

- Current thread waits until target thread finishes
- Moves current thread to WAITING

Overload:

```java
thread.join(milliseconds);
```

Moves to TIMED_WAITING.

---

## Real Use Case:

Ensure main thread waits for worker threads.

---

# 5. interrupt()

```java
thread.interrupt();
```

Interrupts a sleeping or waiting thread.

It does NOT stop thread forcefully.

It:

- Sets interrupt flag
- Causes InterruptedException if sleeping/waiting

Thread must handle interruption properly.

---

# 6. Thread Priorities

```java
thread.setPriority(Thread.MAX_PRIORITY);
```

Priority range:

```
1 (MIN_PRIORITY)
5 (NORM_PRIORITY)
10 (MAX_PRIORITY)
```

Important:

- OS dependent
- No execution guarantee
- Should not be relied on for logic

---

# 7. Execution Control Summary

| Method | State | Releases Lock? |
|--------|--------|---------------|
| sleep() | TIMED_WAITING | No |
| yield() | RUNNABLE | No |
| join() | WAITING | No |
| interrupt() | Depends | No |

---

# 8. Common Mistakes

❌ Using sleep for synchronization  
❌ Assuming yield guarantees execution  
❌ Ignoring InterruptedException  
❌ Relying on priority for correctness  

---

# 9. Interview Questions

1. Difference between sleep and wait?
2. Does sleep release lock?
3. What does yield do?
4. What happens when thread is interrupted?
5. What state during join()?
6. Is priority reliable?

---

# 10. Production Insight

In enterprise systems:

- sleep() used for retries
- join() used in coordination
- interrupt() used in graceful shutdown
- yield() rarely used

Proper execution control prevents:

- Busy waiting
- CPU wastage
- Resource starvation

---

# Conclusion

Execution control methods allow:

- Pausing threads
- Coordinating execution
- Handling interruptions
- Managing lifecycle

These are foundations before synchronization & locks.