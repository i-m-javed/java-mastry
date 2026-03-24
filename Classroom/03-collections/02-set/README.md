# Java Set Interface – HashSet, LinkedHashSet, TreeSet

## 1. Introduction

`Set` represents a collection that:

✔ Does NOT allow duplicates  
✔ May or may not maintain insertion order  
✔ May or may not maintain sorted order  
✔ Allows at most one null (depending on implementation)

Hierarchy:

```
Iterable
  ↳ Collection
       ↳ Set
            ↳ HashSet
            ↳ LinkedHashSet
            ↳ TreeSet
```

Set uniqueness depends entirely on:

- equals()
- hashCode()
- Comparable / Comparator (for TreeSet)

Understanding Set requires understanding hashing and ordering.

---

# 2. HashSet – Internal Working

## Backed By

```
HashMap
```

Internally:

```java
private transient HashMap<E,Object> map;
private static final Object PRESENT = new Object();
```

When you do:

```java
set.add("Java");
```

Internally:

```java
map.put("Java", PRESENT);
```

So:

> HashSet is a thin wrapper over HashMap.

---

## How HashSet Ensures Uniqueness

1. Calls hashCode()
2. Determines bucket
3. Calls equals() inside bucket

If equals() returns true → duplicate rejected.

---

## Time Complexity

| Operation  | Complexity   |
| ---------- | ------------ |
| add()      | O(1) average |
| remove()   | O(1) average |
| contains() | O(1) average |

Worst case:
O(n) if hash collisions occur.

---

## Null Handling

✔ Allows one null  
Because HashMap allows one null key.

---

# 3. LinkedHashSet – Ordered HashSet

Extends HashSet.

Backed by:

```
LinkedHashMap
```

Maintains:

✔ Insertion order  
✔ Predictable iteration order

Internally:

- Maintains doubly linked list across entries.

Performance slightly slower than HashSet.

---

# 4. TreeSet – Sorted Set

Backed by:

```
TreeMap
```

Uses:

✔ Red-Black Tree  
✔ Self-balancing BST

---

## Ordering Mechanism

TreeSet requires:

- Comparable implementation
  OR
- Custom Comparator

Otherwise:

```
ClassCastException
```

---

## Time Complexity

| Operation  | Complexity |
| ---------- | ---------- |
| add()      | O(log n)   |
| remove()   | O(log n)   |
| contains() | O(log n)   |

---

## Null Handling

❌ Does NOT allow null (because it needs comparison)

---

# 5. equals() & hashCode() in Set

For HashSet & LinkedHashSet:

Uniqueness depends on:

- equals()
- hashCode()

If incorrectly implemented:

- Duplicate elements appear
- Retrieval fails
- Set integrity breaks

---

# 6. Comparable vs Comparator (TreeSet)

Comparable:

- Natural ordering
- Implemented inside class

Comparator:

- External ordering logic
- Multiple sorting strategies possible

Interview favorite.

---

# 7. Internal Behavior Comparison

| Feature     | HashSet   | LinkedHashSet | TreeSet     |
| ----------- | --------- | ------------- | ----------- |
| Order       | No        | Insertion     | Sorted      |
| Null        | 1 allowed | 1 allowed     | Not allowed |
| Backed By   | HashMap   | LinkedHashMap | TreeMap     |
| Performance | O(1)      | O(1)          | O(log n)    |

---

# 8. When to Use What

Use HashSet:
✔ Fast lookups  
✔ No ordering needed

Use LinkedHashSet:
✔ Maintain insertion order

Use TreeSet:
✔ Sorted data  
✔ Range operations  
✔ Ceiling/floor queries

---

# 9. Fail-Fast Behavior

All three are fail-fast.

Iterators detect structural modification using modCount.

---

# 10. Production Design Insight

HashSet is used in:

- Caching
- Removing duplicates
- Permission sets
- Tagging systems

TreeSet used in:

- Leaderboards
- Sorted dashboards
- Time-based data

Understanding internal working improves debugging capability.

---

# Conclusion

Set is not just "no duplicates".

It is about:

- Hashing
- Tree balancing
- Ordering guarantees
- equals/hashCode contract
- Performance characteristics
