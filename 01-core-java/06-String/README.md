# Core Java - Strings

## 1. Introduction to String

In Java, String is a class used to store text (sequence of characters).

Example:
String name = "Javed";

String objects are:
- Immutable
- Stored in String Pool (when created using literal)

---

## 2. Ways to Create String

### 1️⃣ Using String Literal (Stored in String Pool)

String s1 = "Java";
String s2 = "Java";

Both refer to same object in String Pool.

### 2️⃣ Using new Keyword (Heap Memory)

String s3 = new String("Java");

This always creates a new object in heap memory.

---

## 3. String Immutability

Strings in Java are immutable.

Example:

String s = "Hello";
s.concat(" World");
System.out.println(s);

Output:
Hello

Reason:
String methods do not modify the original object.
They create a new object.

Correct way:

s = s.concat(" World");

---

## 4. Important String Methods

### length()
Returns number of characters.

str.length()

### charAt(index)
Returns character at given index.

str.charAt(2)

### toUpperCase()
Converts to uppercase.

### toLowerCase()
Converts to lowercase.

### equals()
Compares content of strings.

### == Operator
Compares memory references.

Example:

String a = "Java";
String b = new String("Java");

a == b        → false
a.equals(b)   → true

### substring(start, end)
Extracts part of string.

### contains()
Checks if substring exists.

### replace(old, new)
Replaces characters or words.

### trim()
Removes leading and trailing spaces.

---

## 5. String Pool

String literals are stored in a special memory area called String Constant Pool.

If same literal exists, Java reuses existing object.

Benefits:
- Memory optimization
- Performance improvement

---

## 6. Why String is Immutable?

1. Security (important for URLs, file paths)
2. Thread safety
3. String pool optimization
4. Hashcode caching

---

## 7. StringBuilder

StringBuilder is mutable.

Example:

StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");

Advantages:
- Faster than String
- No new object creation on modification

Not thread-safe.

Use in single-threaded applications.

---

## 8. StringBuffer

StringBuffer is also mutable.

Example:

StringBuffer sb = new StringBuffer("Hello");
sb.append(" World");

Thread-safe (synchronized).
Slower than StringBuilder.

Use in multi-threaded applications.

---

## 9. Difference Between String, StringBuilder, StringBuffer

| Feature        | String | StringBuilder | StringBuffer |
|---------------|--------|---------------|--------------|
| Mutable       | No     | Yes           | Yes          |
| Thread-safe   | No     | No            | Yes          |
| Performance   | Slow   | Fast          | Medium       |
| Memory Usage  | High   | Low           | Medium       |

---

## 10. Performance Note

Repeated string concatenation using String is slow:

String s = "";
for(int i=0;i<10000;i++){
    s += i;
}

Better approach:

StringBuilder sb = new StringBuilder();
for(int i=0;i<10000;i++){
    sb.append(i);
}

