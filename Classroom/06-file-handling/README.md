# Java File Handling

## 1. Why File Handling Matters

File handling is fundamental for:

✔ Reading configuration files  
✔ Writing logs  
✔ Processing CSV / JSON / Text files  
✔ Exporting reports  
✔ Importing bulk data  
✔ Serialization  
✔ Backend batch jobs

In enterprise systems, file I/O is unavoidable.

---

# 2. Java I/O Architecture

Java provides two main I/O models:

## 2.1 Classic I/O (java.io)

- File
- FileReader / FileWriter
- BufferedReader / BufferedWriter
- InputStream / OutputStream
- ObjectInputStream / ObjectOutputStream

---

## 2.2 NIO (java.nio)

Introduced for:

✔ Better performance  
✔ Non-blocking I/O  
✔ Path-based operations  
✔ Scalable systems

Key classes:

- Path
- Files
- Paths
- Channels
- Buffers

---

# 3. Byte Streams vs Character Streams

## 3.1 Byte Streams

- InputStream
- OutputStream
- Used for binary data
- Images, PDFs, files

Example:

```
FileInputStream
FileOutputStream
```

---

## 3.2 Character Streams

- Reader
- Writer
- Used for text data
- Encoding-aware

Example:

```
FileReader
FileWriter
```

---

# 4. Buffered Streams

Buffering improves performance.

Without buffer:

- System call per character

With buffer:

- Reads chunks of data

Example:

```
BufferedReader
BufferedWriter
```

Always prefer buffered streams for text processing.

---

# 5. try-with-resources

Introduced in Java 7.

Automatically closes resources implementing:

```
AutoCloseable
```

Example:

```java
try (BufferedReader br = new BufferedReader(...)) {
    ...
}
```

Prevents:

- Resource leaks
- Memory issues
- File lock issues

---

# 6. File Class

Represents file/directory path.

Does NOT read or write content.

Example:

```java
File file = new File("data.txt");
file.exists();
file.length();
file.delete();
```

---

# 7. NIO – Files & Path

Modern approach:

```java
Path path = Paths.get("data.txt");
Files.readAllLines(path);
Files.write(path, data);
```

More concise and powerful.

---

# 8. Serialization

Converts object → byte stream.

Requires:

```java
implements Serializable
```

Used in:

- Caching
- Session replication
- Object persistence

---

# 9. Checked Exceptions in File Handling

Most I/O operations throw:

- IOException
- FileNotFoundException

Must be handled or declared.

---

# 10. Production Best Practices

✔ Always use try-with-resources  
✔ Prefer BufferedReader over FileReader  
✔ Use NIO Files API when possible  
✔ Avoid hard-coded paths  
✔ Handle encoding explicitly  
✔ Never ignore IO exceptions

---

# 11. Performance Considerations

Bad I/O handling causes:

- Slow systems
- File locks
- Memory leaks
- Resource exhaustion

Understanding I/O architecture is critical before multithreading and JDBC.

---
