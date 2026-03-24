# OOP - Interfaces (Deep Dive)

## 1. What is an Interface?

An interface in Java is a blueprint of a class that contains abstract methods and constants.

It defines a contract that a class must follow.

Example:

interface Vehicle {
    void start();
}

Any class implementing this interface must provide implementation of start().

---

## 2. Why Interface?

Interfaces provide:
- Full abstraction
- Loose coupling
- Multiple inheritance
- Standardization of behavior
- Extensibility

Interfaces define WHAT to do, not HOW to do it.

---

## 3. Syntax of Interface

interface InterfaceName {
    // variables (public static final)
    // methods (public abstract by default)
}

Example:

interface Animal {
    void sound();
}

---

## 4. Important Properties of Interface

1. Methods are public and abstract by default
2. Variables are public static final by default
3. Cannot create object of interface
4. A class uses "implements" keyword
5. A class can implement multiple interfaces
6. Interface supports multiple inheritance

---

## 5. Implementing an Interface

interface Vehicle {
    void start();
}

class Car implements Vehicle {
    public void start() {
        System.out.println("Car starts with key");
    }
}

---

## 6. Multiple Interface Implementation

interface A {
    void methodA();
}

interface B {
    void methodB();
}

class C implements A, B {
    public void methodA() {}
    public void methodB() {}
}

Java supports multiple inheritance using interfaces.

---

## 7. Interface vs Abstract Class

| Feature | Interface | Abstract Class |
|----------|-----------|----------------|
| Methods | Abstract by default | Abstract + Concrete |
| Variables | public static final | Any type |
| Constructor | No | Yes |
| Multiple inheritance | Yes | No |
| Access modifiers | Public only | Any |

---

## 8. Default and Static Methods (Java 8+)

Java 8 introduced:

- default methods
- static methods

Example:

interface Vehicle {
    default void fuelType() {
        System.out.println("Petrol");
    }

    static void info() {
        System.out.println("Vehicle Interface");
    }
}

---

## 9. Functional Interface

An interface with exactly ONE abstract method.

Example:

@FunctionalInterface
interface Drawable {
    void draw();
}

Used in:
- Lambda expressions
- Streams API

- will see this in detail later 

---

## 10. Marker Interface

An interface with no methods.

Example:
Serializable

Used to mark a class for special behavior.

---

## 11. Real-World Example

USB Port:
Interface defines standard.
Different devices implement it differently.

Payment Gateway:
Interface → makePayment()
Classes → CreditCardPayment, UpiPayment, PayPalPayment

---

## 12. Interview Questions

Q1: Can interface have constructor?
No.

Q2: Can interface extend another interface?
Yes.

Q3: Can class extend multiple classes?
No.

Q4: Can interface contain variables?
Yes, but they are public static final.

Q5: Why multiple inheritance allowed via interface?
Because no method implementation conflict (before Java 8).

---
