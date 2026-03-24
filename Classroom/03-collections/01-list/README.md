# Java List Interface

## 1. Introduction

`List` is an ordered collection in the Java Collections Framework (JCF).

Characteristics:

✔ Maintains insertion order  
✔ Allows duplicates  
✔ Allows null elements  
✔ Supports index-based access  
✔ Provides iterator-based traversal

Hierarchy:

```
Iterable
  ↳ Collection
       ↳ List
            ↳ ArrayList
            ↳ LinkedList
            ↳ Vector
            ↳ Stack
```

---

# 2. ArrayList – Internal Architecture

## Internal Structure

```java
transient Object[] elementData;
```

Dynamic resizing array.

Default capacity:

- 10 (after first insertion)

Growth formula:

```
newCapacity = oldCapacity + (oldCapacity >> 1)
```

~1.5x growth.

---

## Time Complexity

| Operation     | Complexity     |
| ------------- | -------------- |
| get(index)    | O(1)           |
| add()         | Amortized O(1) |
| add(index)    | O(n)           |
| remove(index) | O(n)           |
| contains()    | O(n)           |

---

## Memory Characteristics

✔ Cache-friendly  
✔ Low overhead  
✔ Continuous memory block

---

# 3. LinkedList – Internal Architecture

## Internal Structure

Doubly Linked List:

Each node contains:

- Data
- Previous reference
- Next reference

---

## Time Complexity

| Operation     | Complexity |
| ------------- | ---------- |
| get(index)    | O(n)       |
| addFirst()    | O(1)       |
| addLast()     | O(1)       |
| removeFirst() | O(1)       |
| remove(index) | O(n)       |

---

## Memory Characteristics

❌ Extra memory per node  
❌ Poor cache locality  
✔ Faster insertion/deletion (given reference)

---

# 4. Vector (Legacy)

- Synchronized
- Thread-safe
- Slower than ArrayList
- Rarely used in modern systems

Prefer:

- ArrayList
- Or synchronized wrapper

---

# 5. Fail-Fast vs Fail-Safe (CRITICAL)

## Fail-Fast Iterator

Definition:

> Throws ConcurrentModificationException if collection is structurally modified during iteration.

Used by:

- ArrayList
- LinkedList
- HashSet
- HashMap

---

## How Fail-Fast Works Internally

Collections maintain:

```java
protected transient int modCount;
```

Every structural modification increments modCount.

Iterator stores:

```
expectedModCount
```

During iteration:

```
if (modCount != expectedModCount)
    throw ConcurrentModificationException
```

---

## Example (Fail-Fast)

```java
List<Integer> list = new ArrayList<>();

for (Integer num : list) {
    list.remove(num); // ConcurrentModificationException
}
```

---

## Fail-Safe Iterator

Definition:

> Does NOT throw exception if collection is modified during iteration.

Instead:

- Iterates over snapshot copy.

Used by:

- CopyOnWriteArrayList
- CopyOnWriteArraySet

---

## Example (Fail-Safe)

```java
CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

for (Integer num : list) {
    list.add(100); // No exception
}
```

---

## Structural vs Non-Structural Modification

Structural:

- add()
- remove()
- clear()

Non-Structural:

- set(index, value)

Fail-fast only triggers on structural modification.

---

# 6. modCount – important

`modCount` detects unsafe concurrent modification.

Fail-fast is:

- Best-effort detection
- Not guaranteed
- Not thread-safety mechanism

---

# 7. Performance Considerations

ArrayList preferred for:
✔ Read-heavy systems  
✔ Random access

LinkedList preferred for:
✔ Frequent insert/delete at ends

CopyOnWriteArrayList preferred for:
✔ Read-heavy concurrent systems  
❌ Not suitable for write-heavy systems

---

# 9. Production Design Insight

Fail-fast is NOT concurrency control.

If multiple threads modify list:

- Use Concurrent collections
- Or external synchronization

Using ArrayList in concurrent environment is dangerous.

---

# Conclusion

Understanding List is not just about:

- Duplicates
- Ordering

It is about:

- Internal memory model
- Performance trade-offs
- Iterator behavior
- Concurrent modification risks
- Production-level design decisions
