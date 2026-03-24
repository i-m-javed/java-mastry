# OOP - Inheritance

## 1. What is Inheritance?

Inheritance is a mechanism in Java where one class acquires the properties and behaviors of another class.

It promotes:
- Code reusability
- Hierarchical classification
- Extensibility
- Maintainability

Syntax:

class Child extends Parent {
}

---

## 2. Terminology

Parent Class → Superclass  
Child Class → Subclass  

Example:

class Animal { }      // Parent
class Dog extends Animal { }   // Child

---

## 3. Why Inheritance?

Without inheritance:

class Dog {
    String name;
    void eat() {}
}

class Cat {
    String name;
    void eat() {}
}

Code duplication occurs.

With inheritance:

class Animal {
    String name;
    void eat() {}
}

class Dog extends Animal {}
class Cat extends Animal {}

Code reuse achieved.

---

## 4. Types of Inheritance in Java

Java supports:

1. Single Inheritance
2. Multilevel Inheritance
3. Hierarchical Inheritance

Java does NOT support:
- Multiple inheritance using classes (to avoid ambiguity)

---

## 5. Single Inheritance

One child inherits from one parent.

class Animal {
    void eat() {}
}

class Dog extends Animal {
    void bark() {}
}

---

## 6. Multilevel Inheritance

A class inherits from a class that itself inherits from another class.

class Animal {}
class Dog extends Animal {}
class Puppy extends Dog {}

---

## 7. Hierarchical Inheritance

Multiple classes inherit from same parent.

class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}

---

## 8. super Keyword

Used to refer to parent class members.

Uses:
1. Access parent variable
2. Call parent method
3. Call parent constructor

Example:

super.variableName;
super.methodName();
super();

---

## 9. Constructor and Inheritance

When child object is created:
1. Parent constructor runs first
2. Then child constructor runs

Java automatically calls super() if not written explicitly.

---

## 10. Method Overriding (Introduction)

If child class provides its own implementation of parent method:

class Animal {
    void sound() {}
}

class Dog extends Animal {
    @Override
    void sound() {}
}

This is called method overriding.

---

## 11. Important Rules

- private members are NOT inherited
- Constructors are NOT inherited
- Parent class reference can refer to child object
- super() must be first statement in constructor

---

## 12. Interview Questions

Q1: Why Java does not support multiple inheritance?
To avoid diamond problem and ambiguity.

Q2: What is super?
Keyword used to access parent class members.

Q3: Can constructor be inherited?
No.

Q4: What is method overriding?
Child provides its own implementation of parent method.

---

## 13. Summary

- Inheritance promotes code reuse
- Uses extends keyword
- Supports single, multilevel, hierarchical inheritance
- super accesses parent members
- Parent constructor runs before child constructor