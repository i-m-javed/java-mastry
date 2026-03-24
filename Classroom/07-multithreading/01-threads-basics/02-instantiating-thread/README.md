# Instantiating a Thread – Object Creation & Thread Configuration 

## 1. What Does “Instantiating a Thread” Mean?

Instantiating a thread means:

> Creating a Thread object in memory.

Important distinction:

- Defining → Writing the task logic (run method)
- Instantiating → Creating the Thread object
- Starting → Calling start() to begin execution

Thread lifecycle always begins with instantiation.

---

## 2. Thread Constructors

Thread class provides multiple constructors.

### Common Constructors:

```java
Thread()
Thread(Runnable target)
Thread(Runnable target, String name)
Thread(String name)
Thread(ThreadGroup group, Runnable target)
```

Most commonly used in production:

```java
new Thread(runnableTask, "Worker-1");
```

---

## 3. Runnable vs Thread Instantiation

### Case 1: Extending Thread

```java
Thread t = new MyThread();
```

Thread object itself contains task logic.

---

### Case 2: Implementing Runnable (Preferred)

```java
Runnable task = new MyTask();
Thread t = new Thread(task);
```

Here:

- Runnable defines task
- Thread defines execution

Cleaner separation.

---

## 4. Creating Multiple Threads from Same Task

One Runnable instance can be used to create multiple threads:

```java
Runnable task = new MyTask();

Thread t1 = new Thread(task);
Thread t2 = new Thread(task);
```

⚠ Important:

If Runnable contains shared state → race conditions possible.

This is where concurrency issues begin.

---

## 5. Thread Naming During Instantiation

Naming threads is critical for debugging.

```java
Thread t = new Thread(task, "Payment-Processor-1");
```

Useful in:

- Logging
- Debugging
- Production monitoring

---

## 6. Thread Configuration Before Start

Before calling start(), you can configure:

- Name
- Priority
- Daemon status
- UncaughtExceptionHandler

Example:

```java
t.setPriority(Thread.MAX_PRIORITY);
t.setDaemon(true);
```

After start(), configuration should not be modified.

---

## 7. Thread Object vs OS Thread

Creating Thread object does NOT create OS thread immediately.

OS thread is created when:

```
start() is called.
```

Instantiation alone does not start execution.

---

## 8. Common Mistakes

❌ Creating thread but never calling start()  
❌ Calling run() instead of start()  
❌ Sharing mutable state unknowingly  
❌ Forgetting thread naming  

---

## 9. Questions

1. What happens when you instantiate a thread?
2. Does instantiation create new OS thread?
3. Can multiple threads share same Runnable?
4. Why is Runnable preferred?
5. Can you change thread name after start?
6. What is daemon thread?

---

## 10. Production Insight

In real systems:

- We rarely instantiate threads manually.
- We use ExecutorService.
- Thread pools manage instantiation internally.

Understanding instantiation is still critical before moving to thread pools.

---

