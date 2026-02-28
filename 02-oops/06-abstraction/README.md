# OOP - Abstraction

## 1. What is Abstraction?

Abstraction is the process of hiding implementation details and showing only essential features to the user.

It focuses on:

- What an object does
- Not how it does it

Example:
When you drive a car, you use steering, accelerator, brake.
You don’t know the internal engine mechanism.

That is abstraction.

---

## 2. Why Abstraction?

Abstraction provides:

- Security (hide internal details)
- Reduced complexity
- Improved maintainability
- Clean architecture
- Loose coupling

---

## 3. How to Achieve Abstraction in Java?

Java achieves abstraction using:

1. Abstract Class
2. Interface

---

# PART A – ABSTRACT CLASS

## 4. What is an Abstract Class?

An abstract class:

- Is declared using abstract keyword
- Cannot be instantiated
- May contain abstract and non-abstract methods

Example:

abstract class Animal {
abstract void sound();
}

---

## 5. Abstract Method

An abstract method:

- Has no body
- Must be implemented by child class

abstract void sound();

---

## 6. Rules of Abstract Class

- Cannot create object of abstract class
- If class has abstract method → class must be abstract
- Child class must implement abstract methods
- Can have constructors
- Can have normal methods

---

# PART B – INTERFACE

## 7. What is an Interface?

An interface:

- Is 100% abstraction (before Java 8)
- Contains abstract methods by default
- Supports multiple inheritance

Example:

interface Vehicle {
void start();
}

---

## 8. Rules of Interface

- Methods are public and abstract by default
- Variables are public static final
- A class uses "implements" keyword
- A class can implement multiple interfaces

---

## 9. Abstract Class vs Interface

| Feature              | Abstract Class      | Interface                                        |
| -------------------- | ------------------- | ------------------------------------------------ |
| Object creation      | Not allowed         | Not allowed                                      |
| Methods              | Abstract + Concrete | Abstract (default & static allowed after Java 8) |
| Variables            | Any type            | public static final only                         |
| Multiple inheritance | No                  | Yes                                              |
| Constructor          | Yes                 | No                                               |

---

## 10. When to Use What?

Use Abstract Class:

- When classes share common base behavior
- When partial abstraction needed

Use Interface:

- When defining a contract
- When multiple inheritance required

---

## 11. Real-World Analogy

ATM Machine:
Interface = What user can do (withdraw, deposit)
Internal logic hidden.

Remote Control:
You press button (method)
You don’t see internal electronics.

---

## 12. Interview Questions

Q1: Can abstract class have constructor?
Yes.

Q2: Can interface have constructor?
No.

Q3: Can we create object of abstract class?
No.

Q4: Why interface supports multiple inheritance?
Because it contains only method declarations (no ambiguity).

Q5: Difference between abstraction and encapsulation?
Encapsulation → Hides data
Abstraction → Hides implementation

---

