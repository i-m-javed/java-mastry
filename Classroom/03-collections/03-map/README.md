# Java Map Interface – (HashMap, LinkedHashMap, TreeMap, ConcurrentHashMap)

## 1. Introduction

`Map` represents a key-value data structure.

Characteristics:

✔ Stores key-value pairs  
✔ Keys must be unique  
✔ Values can be duplicate  
✔ Each key maps to exactly one value

Hierarchy:

```
Map
 ├── HashMap
 ├── LinkedHashMap
 ├── TreeMap
 ├── Hashtable
 └── ConcurrentHashMap
```

Map is NOT part of Collection hierarchy.

---

# 2. HashMap – Internal Architecture

## Data Structure

HashMap uses:

- Array of Node<K,V>
- Bucket system
- Linked List (pre-Java 8)
- Red-Black Tree (Java 8+ for high collisions)

---

## Internal Structure

```java
static class Node<K,V> {
    final int hash;
    final K key;
    V value;
    Node<K,V> next;
}
```

---

## How put() Works

1. Compute hashCode()
2. Apply hash spreading
3. Determine bucket index
4. If bucket empty → insert
5. If collision →
   - Traverse linked list
   - If too many collisions → convert to Red-Black Tree (treeify)

---

## HashMap Treeification (Java 8+)

If bucket size > 8  
AND table size ≥ 64

→ Converts linked list into Red-Black Tree.

This improves worst-case from:

O(n) → O(log n)

---

## Time Complexity

| Operation | Average | Worst    |
| --------- | ------- | -------- |
| put()     | O(1)    | O(log n) |
| get()     | O(1)    | O(log n) |
| remove()  | O(1)    | O(log n) |

---

## Null Handling

✔ One null key allowed  
✔ Multiple null values allowed

---

# 3. LinkedHashMap

Extends HashMap.

Maintains:

✔ Insertion order  
✔ Optional access-order (LRU behavior)

Uses:

- Doubly linked list internally

Used in:

- Caches
- LRU implementations

---

# 4. TreeMap

Backed by:

```
Red-Black Tree
```

Maintains:

✔ Sorted keys

Ordering via:

- Comparable
  OR
- Comparator

---

## Time Complexity

O(log n) for:

- put
- get
- remove

---

## Null Handling

❌ Does NOT allow null key  
(because comparison required)

---

# 5. ConcurrentHashMap

Designed for concurrency.

Features:

✔ Thread-safe  
✔ No full locking  
✔ Uses bucket-level locking  
✔ Weakly consistent iterators

Does NOT allow:
❌ null key  
❌ null value

Reason:
To avoid ambiguity in concurrent reads.

---

# 6. HashMap Internal Mechanics (Important)

## Hash Calculation

```java
hash = key.hashCode() ^ (key.hashCode() >>> 16);
```

Spreads high bits into low bits.

---

## Bucket Index Calculation

```java
index = (n - 1) & hash;
```

Where n is power of 2.

---

# 7. equals() & hashCode() in Map

For key uniqueness:

1. hashCode() decides bucket
2. equals() checks equality inside bucket

If equals/hashCode contract broken:

- Data loss
- Retrieval failure
- Duplicate keys
- Memory leak

---

# 8. Fail-Fast Behavior

HashMap, TreeMap, LinkedHashMap are fail-fast.

ConcurrentHashMap is NOT fail-fast.
It uses weakly consistent iterator.

---

# 9. Map Comparison Table

| Feature     | HashMap    | LinkedHashMap  | TreeMap        | ConcurrentHashMap |
| ----------- | ---------- | -------------- | -------------- | ----------------- |
| Order       | No         | Insertion      | Sorted         | No                |
| Null Key    | 1          | 1              | No             | No                |
| Null Value  | Yes        | Yes            | Yes            | No                |
| Thread-Safe | No         | No             | No             | Yes               |
| Backed By   | Array+Node | HashMap+Linked | Red-Black Tree | Segmented/Bucket  |

---

# 10. Production Design Insight

HashMap is used in:

- Caching
- Configuration maps
- Session storage
- Indexing
- JSON parsing
- ORM frameworks

Understanding its internal design is critical for scalable backend systems.

---

# Conclusion

Map is not just key-value storage.

It is:

- Hashing architecture
- Tree balancing
- Collision management
- Concurrency engineering
- Performance optimization
