# Core Java - Static Members

## 1. What is static in Java?

The static keyword belongs to the class rather than the object.

Static members:

- Are shared among all objects
- Are loaded once in memory
- Can be accessed without creating object

Example:

static int count;

---

## 2. Why Static?

Static is used when:

- A value should be common to all objects
- A method does not depend on object state
- Utility methods are needed
- Memory optimization is required

---

## 3. Static Variables (Class Variables)

A static variable:

- Belongs to class
- Shared by all objects
- Stored in method area (class memory)

Example:

class Student {
static String schoolName = "ABC School";
}

All students share same schoolName.

---

## 4. Static Methods

A static method:

- Belongs to class
- Can be called without object
- Cannot access non-static members directly

Example:

class MathUtil {
static int square(int x) {
return x \* x;
}
}

Call using:

MathUtil.square(5);

---

## 5. Static Block

A static block:

- Executes once when class is loaded
- Used for initialization

Example:

static {
System.out.println("Static block executed");
}

Executed before main method.

---

## 6. Static vs Instance Members

| Feature                      | Static     | Instance         |
| ---------------------------- | ---------- | ---------------- |
| Belongs to                   | Class      | Object           |
| Memory                       | One copy   | Multiple copies  |
| Access using                 | Class name | Object reference |
| Can access instance members? | No         | Yes              |

---

## 7. Why Static Method Cannot Access Non-Static Members?

Because:

- Static belongs to class
- Non-static belongs to object
- Object may not exist yet

Static methods execute before object creation.

---

## 8. Real-World Example

Bank:

Interest rate → static (same for all)
Account balance → non-static (different per account)

---

## 9. Static and Memory

When class loads:

- Static variables initialized
- Static block executes
- Memory allocated once

Objects share same static memory.

---

## 10. Static Nested Class

A class inside another class marked static.

Example:

class Outer {
static class Inner {}
}

Does not require outer object.

---

## 11. Important Questions

Q1: Can static method access non-static variable?
No.

Q2: Can we override static method?
No (it is method hiding, not overriding).

Q3: When does static block execute?
When class loads.

Q4: Can constructor be static?
No.

Q5: Why main method is static?
So JVM can call it without creating object.

---
