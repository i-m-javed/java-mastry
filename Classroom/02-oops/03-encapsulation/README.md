# OOP - Encapsulation

## 1. What is Encapsulation?

Encapsulation is the process of wrapping data (variables) and code (methods) together into a single unit (class) and restricting direct access to some components.

It is achieved by:
- Declaring variables as private
- Providing public getter and setter methods

Encapsulation = Data Hiding + Controlled Access

---

## 2. Why Encapsulation?

Encapsulation ensures:
- Data security
- Controlled modification of data
- Improved maintainability
- Better flexibility
- Validation before updating values

Without encapsulation, data can be modified incorrectly.

---

## 3. How to Achieve Encapsulation in Java?

1. Make variables private
2. Provide public getter and setter methods

Example:

class Student {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

---

## 4. Getters and Setters

Getter → Used to retrieve value  
Setter → Used to update value  

Naming Convention:
- getVariableName()
- setVariableName()

Example:

private int age;

public int getAge() {
    return age;
}

public void setAge(int age) {
    this.age = age;
}

---

## 5. Benefits of Encapsulation

1. Protects sensitive data
2. Allows validation before setting values
3. Makes code flexible
4. Supports data abstraction
5. Reduces dependency between classes

---

## 6. Without Encapsulation (Bad Practice)

class Student {
    public int age;
}

Direct access:
student.age = -10;   // Invalid value allowed

---

## 7. With Encapsulation (Good Practice)

public void setAge(int age) {
    if(age > 0) {
        this.age = age;
    }
}

Now invalid values are restricted.

---

## 8. Real-World Analogy

ATM Machine:
You cannot access bank balance directly.
You interact through buttons (methods).

Data → Private
Buttons → Public methods

---

