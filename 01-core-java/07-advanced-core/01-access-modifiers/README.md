### TO BE STUDIED AFTER OOPS

# Core Java - Access Modifiers

## 1. What are Access Modifiers?

Access Modifiers in Java define the visibility or accessibility of classes, variables, methods, and constructors.

They control:

- Who can access a member
- From where it can be accessed
- Level of security and encapsulation

---

## 2. Types of Access Modifiers in Java

Java provides four access modifiers:

1. private
2. default (no modifier)
3. protected
4. public

---

## 3. private

- Accessible only within the same class.
- Not accessible outside the class.
- Most restrictive.

Example:

private int age;

Use case:
Data hiding (Encapsulation).

---

## 4. default (Package-Private)

- No keyword used.
- Accessible only within the same package.
- Not accessible outside package.

Example:

int age;

---

## 5. protected

- Accessible within same package.
- Accessible outside package only through inheritance.
- Used in inheritance hierarchy.

Example:

protected int age;

---

## 6. public

- Accessible everywhere.
- Least restrictive.

Example:

public int age;

---

## 7. Access Level Table

| Modifier  | Same Class | Same Package | Subclass (Different Package) | Other Package |
| --------- | ---------- | ------------ | ---------------------------- | ------------- |
| private   | Yes        | No           | No                           | No            |
| default   | Yes        | Yes          | No                           | No            |
| protected | Yes        | Yes          | Yes                          | No            |
| public    | Yes        | Yes          | Yes                          | Yes           |

---

## 8. Access Modifiers for Classes

Top-level classes can only be:

- public
- default

private and protected are NOT allowed for top-level classes.

---

## 9. Why Access Modifiers Are Important?

- Security
- Encapsulation
- Controlled access
- Code maintainability
- Prevent misuse

---

## 10. Real-World Analogy

Bank Account:

- Balance → private
- Deposit method → public
- Internal calculations → private

You cannot directly change balance.

---

## 11. Questions

-- Difference between protected and default?
Protected allows subclass access outside package.
Default does not.
