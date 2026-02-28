# OOP - Classes & Objects

## 1. What is Object-Oriented Programming?

Object-Oriented Programming (OOP) is a programming paradigm that organizes software design around objects rather than functions.

Java is primarily an object-oriented language.

OOP is based on:
- Classes
- Objects
- Encapsulation
- Abstraction
- Inheritance
- Polymorphism

Classes and Objects form the foundation of OOP.

---

## 2. What is a Class?

A class is a blueprint or template used to create objects.

It defines:
- Properties (variables / data members)
- Behavior (methods / functions)

Example:

class Student {
    String name;
    int age;

    void display() {
        System.out.println(name + " " + age);
    }
}

A class does NOT occupy memory until an object is created.

---

## 3. What is an Object?

An object is an instance of a class.

Created using the new keyword.

Example:

Student s1 = new Student();

Here:
- Student → class
- s1 → reference variable
- new Student() → object created in heap memory

---

## 4. Memory Representation

When object is created:

Student s1 = new Student();

Memory structure:

Stack:
- s1 (reference variable)

Heap:
- Actual Student object

Reference variable stores memory address of object.

Multiple objects have separate memory in heap.

---

## 5. Accessing Object Members

Using dot operator:

s1.name = "Javed";
s1.age = 22;
s1.display();

Dot operator allows access to:
- Instance variables
- Methods

---

## 6. Types of Variables in Class

1. Instance Variables
   - Declared inside class, outside method
   - Belong to object

2. Local Variables
   - Declared inside method
   - Scope limited to method

3. Static Variables (covered later)
   - Belong to class, not object

---

## 7. Multiple Objects

Each object has its own copy of instance variables.

Example:

Student s1 = new Student();
Student s2 = new Student();

Changes in s1 do not affect s2.

---

## 8. Real-World Analogy

Class → Blueprint of house  
Object → Actual constructed house  

Blueprint alone cannot live in.
Object is real usable entity.

---

