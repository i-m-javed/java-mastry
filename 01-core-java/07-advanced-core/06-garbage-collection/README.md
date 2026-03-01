# Garbage Collection in Java

## 1. Introduction

Garbage Collection (GC) is the automatic memory management mechanism in Java.

Unlike C/C++, Java developers do NOT manually free memory.
The JVM identifies and removes unreachable objects from heap memory.

Understanding GC is critical for:
- Performance tuning
- Memory leak detection
- Backend scalability
- Microservices optimization
- Production debugging

---

## 2. Java Memory Structure Overview

### 1️⃣ Stack Memory
- Stores local variables
- Stores method calls
- Thread-specific
- Automatically cleaned when method ends

### 2️⃣ Heap Memory
- Stores objects
- Shared among threads
- Managed by Garbage Collector

### 3️⃣ Method Area (MetaSpace)
- Class metadata
- Static variables
- Constant pool

GC primarily works on the **Heap**.

---

## 3. How Garbage Collection Works

GC removes objects that are:

> No longer reachable from GC Roots

### GC Roots Include:
- Local variables in stack
- Active threads
- Static variables
- JNI references

If an object cannot be reached from GC roots → Eligible for GC.

Important:
Eligible ≠ Immediately removed

---

## 4. Generational Garbage Collection Model

Java heap is divided into:

### Young Generation
- Eden Space
- Survivor S0
- Survivor S1

### Old Generation (Tenured)
Long-living objects promoted here.

### Permanent / MetaSpace
Stores class metadata (since Java 8)

---

## 5. Minor vs Major GC

### Minor GC
- Cleans Young Generation
- Frequent
- Fast

### Major GC
- Cleans Old Generation
- Slower
- Causes Stop-The-World pause

---

## 6. Object Lifecycle

1. Object created in Eden
2. Survives Minor GC → moves to Survivor
3. Survives multiple cycles → promoted to Old Gen
4. Becomes unreachable → removed during GC

---

## 7. When Is an Object Eligible for GC?

### Case 1: Nullifying Reference

```java
Employee emp = new Employee();
emp = null;
```

### Case 2: Reassigning Reference

```java
Employee emp1 = new Employee();
Employee emp2 = new Employee();
emp1 = emp2;
```

First object becomes eligible.

### Case 3: Method Scope Ends

```java
void method() {
    Employee e = new Employee();
}
```

After method ends → eligible.

### Case 4: Isolated Objects (Island of Isolation)

Two objects referencing each other but no external reference.

They are still eligible for GC.

---

## 8. finalize() – Deprecated Concept

Earlier:

```java
protected void finalize()
```

Called before GC removes object.

Now deprecated (Java 9+).

Never rely on finalize() for resource cleanup.

Use:
- try-with-resources
- AutoCloseable

---

## 9. System.gc() Myth

Calling:

```java
System.gc();
```

Does NOT guarantee GC.
It is only a request to JVM.

JVM decides when to run GC.

---

## 10. Memory Leak in Java?

Yes.

Even with GC, memory leaks occur when:
- Objects remain referenced unintentionally
- Static collections grow infinitely
- Listeners not deregistered
- ThreadLocals misused

Example:

```java
static List<Object> cache = new ArrayList<>();
```

Objects stored here never become eligible.

---

## 11. Stop-The-World (STW)

During GC:
- All application threads pause
- JVM performs memory cleanup

Frequent Full GC causes performance issues.

---

## 12. Modern Garbage Collectors

- Serial GC
- Parallel GC
- CMS (deprecated)
- G1 GC (default)
- ZGC (low latency)
- Shenandoah

Backend engineers should at least know G1 GC basics.

---

## 13. Interview Questions

1. How does GC determine eligibility?
2. What are GC roots?
3. What is Stop-The-World?
4. Difference between Minor and Major GC?
5. Can Java have memory leaks?
6. What is island of isolation?
7. Why is finalize() deprecated?
8. What is G1 GC?

---

## 14. Production Insight

Symptoms of GC problems:
- High CPU usage
- Application pauses
- OutOfMemoryError
- Frequent Full GC logs

Real debugging tools:
- VisualVM
- JConsole
- GC logs
- Heap dumps

---

## 15. Important Clarification

You cannot:
- Force GC
- Predict exact GC timing
- Control exact object deletion

You CAN:
- Design better object lifecycle
- Avoid memory leaks
- Reduce object churn

---

## Conclusion

Garbage Collection is not just memory cleanup.

It affects:
- Application performance
- Scalability
- Latency
- Stability
