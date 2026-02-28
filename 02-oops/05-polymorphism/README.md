# OOP - Polymorphism

## 1. What is Polymorphism?

Polymorphism means "many forms".

In Java, polymorphism allows one interface (method or reference) to behave differently based on the object.

It enables:

- Flexibility
- Reusability
- Dynamic behavior
- Clean and scalable design

There are two types of polymorphism in Java:

1. Compile-time Polymorphism (Method Overloading)
2. Runtime Polymorphism (Method Overriding)

---

## 2. Compile-Time Polymorphism (Method Overloading)

Method overloading occurs when multiple methods in the same class have:

- Same method name
- Different parameter list (type or number)

Example:

class Calculator {
int add(int a, int b) {
return a + b;
}

    double add(double a, double b) {
        return a + b;
    }

}

Method call is decided at compile time.

---

## 3. Rules for Method Overloading

- Method name must be same
- Parameter list must differ
- Return type alone cannot differentiate overloaded methods

Invalid:

int add(int a, int b)
double add(int a, int b) ❌ (same parameters)

---

## 4. Runtime Polymorphism (Method Overriding)

Method overriding occurs when:

- A child class provides its own implementation of a parent method
- Method signature must be same

Example:

class Animal {
void sound() {
System.out.println("Animal makes sound");
}
}

class Dog extends Animal {
@Override
void sound() {
System.out.println("Dog barks");
}
}

---

## 5. Dynamic Method Dispatch

When a parent reference refers to a child object:

Animal a = new Dog();
a.sound();

The method call is decided at runtime.

This is called Dynamic Method Dispatch.

---

## 6. Important Rules for Overriding

- Method signature must be same
- Access modifier cannot be more restrictive
- Cannot override static methods
- Cannot override final methods
- Private methods are not overridden

---

## 7. Polymorphism vs Overloading vs Overriding

| Feature               | Overloading          | Overriding      |
| --------------------- | -------------------- | --------------- |
| Happens at            | Compile time         | Runtime         |
| Inheritance required? | No                   | Yes             |
| Method signature      | Different parameters | Same parameters |
| Binding               | Static binding       | Dynamic binding |

---

## 8. Why Polymorphism is Important?

- Supports loose coupling
- Allows dynamic behavior
- Enhances extensibility
- Makes code flexible

---

## 9. Interview Questions

Q1: What is difference between overloading and overriding?
Overloading → Compile-time
Overriding → Runtime

Q2: What is dynamic method dispatch?
Parent reference calling child overridden method at runtime.

Q3: Can we override static method?
No.

Q4: Can we override private method?
No.

Q5: Can return type change while overriding?
Yes, if it is covariant (child type).

---
