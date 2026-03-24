# Core Java - Enums

## 1. What is an Enum?

Enum (Enumeration) is a special data type in Java used to define a collection of constants.

Example:

enum Day {
    MONDAY, TUESDAY, WEDNESDAY
}

Enums are:
- Type-safe
- Fixed set of constants
- Internally subclasses of java.lang.Enum

---

## 2. Why Use Enums?

Without enum:

String day = "MONDAY";

Problems:
- Typing mistakes possible
- No validation
- Not type-safe

With enum:

Day day = Day.MONDAY;

Now:
- No invalid value allowed
- Compile-time safety
- Cleaner code

---

## 3. Basic Enum Example

enum Status {
    SUCCESS, FAILED, PENDING
}

Usage:

Status s = Status.SUCCESS;

---

## 4. Enum with Switch

enum Day {
    MONDAY, TUESDAY, WEDNESDAY
}

switch(day) {
    case MONDAY:
        System.out.println("Start of week");
        break;
}

Enums work perfectly with switch.

---

## 5. Enum with Variables and Constructor

Enums can have:
- Variables
- Constructors
- Methods

Example:

enum Level {
    LOW(1),
    MEDIUM(2),
    HIGH(3);

    private int value;

    Level(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

Important:
Enum constructor is always private.

---

## 6. Enum Methods

All enums extend java.lang.Enum.

Useful built-in methods:

values()      → Returns array of constants
valueOf()     → Returns enum constant from string
ordinal()     → Returns index position
name()        → Returns constant name

Example:

for(Day d : Day.values()) {
    System.out.println(d);
}

---

## 7. Enum vs Constants (static final)

Old way:

public static final int MONDAY = 1;

Problems:
- No type safety
- Hard to manage

Enum is:
- More readable
- Safer
- Structured

---

## 8. Real-World Use Cases

- Order status
- Payment status
- User roles
- API response types
- Log levels
- Directions
- Configuration types

---

## 9. Important Questions

Q1: Can enum have constructor?
Yes (always private).

Q2: Can enum extend a class?
No (it already extends Enum).

Q3: Can enum implement interface?
Yes.

Q4: Is enum a class?
Yes, internally it is a class.

Q5: Why enum is better than constants?
Type safety + cleaner design.

---
