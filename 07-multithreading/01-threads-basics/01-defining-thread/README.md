# Defining a Thread

## 1. What Does “Defining a Thread” Mean?

Defining a thread means:

> Defining the task (unit of work) that will run concurrently.

Important distinction:

- Thread = Worker
- Task = Work to be done

When defining a thread, we are defining:

```
What code should run in parallel?
```

---

## 2. Two Ways to Define a Thread

Java provides two primary approaches:

### 1️⃣ Extending Thread Class

```java
class MyThread extends Thread {
    public void run() {
        // task logic
    }
}
```

### 2️⃣ Implementing Runnable Interface (Preferred)

```java
class MyTask implements Runnable {
    public void run() {
        // task logic
    }
}
```

---

## 3. Why Runnable is Preferred

Java supports:

> Single inheritance

If you extend Thread:

You cannot extend another class.

If you implement Runnable:

You can still extend another class.

Cleaner design:

- Task definition separated from thread execution
- Better for ExecutorService
- Better object-oriented design

---

## 4. What Actually Makes Code Concurrent?

Overriding run() does NOT create a thread.

Calling start() creates a new thread.

```
run() → normal method call
start() → new thread created
```

This is a very common interview trap.

---

## 5. Thread is Just a Class

Thread internally:

- Extends Object
- Implements Runnable

Thread class internally calls:

```
run()
```

inside new execution path when start() is invoked.

---

## 6. Thread Naming

Every thread has a name.

Default naming:

```
Thread-0
Thread-1
```

You can set custom name:

```java
new Thread(task, "Worker-1");
```

Naming is critical for debugging production systems.

---

## 7. Lambda and Runnable

Since Runnable is a functional interface:

```java
Runnable task = () -> {
    System.out.println("Task running");
};
```

Modern style thread definition.

---

## 8. Thread Safety Consideration

When defining a thread:

Be careful about:

- Shared variables
- Mutable state
- Static variables
- Object references

Thread definition phase is where many race conditions begin.

---

## 9. Questions

1. Difference between defining and starting a thread?
2. Why Runnable preferred over Thread?
3. What happens if run() called directly?
4. Is Thread class a functional interface?
5. Can you define thread using lambda?
6. What is relationship between Thread and Runnable?

---
