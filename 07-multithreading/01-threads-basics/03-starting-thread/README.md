# Starting a Thread 

## 1. What Does “Starting a Thread” Mean?

Starting a thread means:

> Requesting the JVM to create a new execution path.

This is done using:

```java
thread.start();
```

Important:

Calling start() does NOT immediately run the thread.
It transitions the thread from NEW → RUNNABLE state.

---

## 2. start() vs run()

This is one of the most common interview traps.

### start()

- Creates a new OS-level thread.
- Calls run() internally.
- Executes concurrently.

### run()

- Normal method call.
- Executes in current thread.
- No new thread created.

Example:

```java
thread.run();  // Executes in main thread
thread.start(); // Executes in new thread
```

---

## 3. Internal Mechanism of start()

When start() is invoked:

1. JVM creates a new thread.
2. Thread is moved to RUNNABLE state.
3. OS scheduler decides execution timing.
4. run() method executes in new stack.

---

## 4. Thread Lifecycle Transition

```
NEW → RUNNABLE → RUNNING → TERMINATED
```

Calling start() twice:

```
IllegalThreadStateException
```

A thread can be started only once.

---

## 5. Why Thread Cannot Be Restarted

After termination:

- Thread resources are released.
- Execution stack is destroyed.

You must create a new Thread object.

---

## 6. Execution Order Is Not Guaranteed

Example:

```java
t1.start();
t2.start();
```

There is no guarantee which thread runs first.

Thread scheduling is:

- OS dependent
- JVM dependent
- Non-deterministic

Never write logic depending on execution order.

---

## 7. Multiple Threads Starting

Multiple threads may interleave output:

```
Worker-1
Worker-2
Worker-1
Worker-2
```

This is normal.

---

## 8. Common Mistakes

❌ Calling run() instead of start()  
❌ Starting thread twice  
❌ Assuming execution order  
❌ Not handling exceptions  

---

## 9. Interview Questions

1. What is difference between start() and run()?
2. Can a thread be restarted?
3. What happens if start() called twice?
4. Who calls run() internally?
5. Does start() guarantee immediate execution?
6. What state is thread in after start()?

---

## 10. Production Insight

In real-world systems:

- Thread.start() is rarely used directly.
- ExecutorService manages start internally.
- Understanding start mechanics is essential before thread pools.

Starting threads incorrectly leads to:

- Race conditions
- Resource leaks
- Hard-to-debug behavior

---

## Conclusion

start() triggers concurrent execution.

run() is just a method.

