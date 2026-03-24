# OOP - Constructors

## 1. What is a Constructor?

A constructor is a special method used to initialize objects.

It:
- Has the same name as the class
- Does not have a return type
- Is automatically called when an object is created

Example:

class Student {
    Student() {
        System.out.println("Constructor called");
    }
}

---

## 2. Why Constructors Are Needed

Without constructors, object variables may remain uninitialized.

Constructors ensure:
- Proper initialization of instance variables
- Object is created in a valid state
- Mandatory values are provided during object creation

---

## 3. Types of Constructors

### 1️⃣ Default Constructor

If no constructor is defined, Java provides a default constructor automatically.

Example:

class Student {
}

Java internally creates:

Student() {}

---

### 2️⃣ User-Defined Default Constructor

class Student {
    Student() {
        System.out.println("Student created");
    }
}

---

### 3️⃣ Parameterized Constructor

Used to pass values during object creation.

class Student {
    String name;
    int age;

    Student(String n, int a) {
        name = n;
        age = a;
    }
}

Object creation:

Student s1 = new Student("Javed", 22);

---

## 4. Constructor vs Method

| Feature        | Constructor | Method |
|---------------|------------|--------|
| Name          | Same as class | Any name |
| Return Type   | No return type | Must have return type |
| Purpose       | Initialize object | Perform operations |
| Called When   | Object creation | Explicit call |

---

## 5. The "this" Keyword

"this" refers to the current object.

Used when:
- Instance variable and parameter have same name
- Calling another constructor

Example:

Student(String name) {
    this.name = name;
}

Without "this", local variable shadows instance variable.

---

## 6. Constructor Overloading

Multiple constructors in same class with different parameters.

Example:

Student() {}
Student(String name) {}
Student(String name, int age) {}

This is called constructor overloading.

---

## 7. Constructor Chaining

Calling one constructor from another using "this()".

Example:

Student() {
    this("Unknown", 0);
}

Student(String name, int age) {
    this.name = name;
    this.age = age;
}

Rules:
- this() must be first statement inside constructor.

---

## 8. Important Interview Questions

Q1: Can constructor be static?
No.

Q2: Can constructor be private?
Yes (used in Singleton pattern).

Q3: Can constructor return value?
No.

Q4: What happens if constructor is not defined?
Java provides default constructor.

Q5: Can we call constructor manually?
No. It is called automatically using new keyword.

---

## 9. Summary

- Constructor initializes object
- Same name as class
- No return type
- Can be overloaded
- "this" keyword avoids variable shadowing
- Constructor chaining improves code reuse