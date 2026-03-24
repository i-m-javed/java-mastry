# 01 - TDD

---

# 1️⃣ What is TDD?

TDD (Test-Driven Development) is a development approach where:

> You write tests BEFORE writing production code.

Development cycle:

1. Write a failing test (RED)
2. Write minimal code to pass (GREEN)
3. Refactor safely (REFACTOR)

Repeat.

This is called:

👉 **Red → Green → Refactor**

---

# 2️⃣ History of TDD

- Introduced by Kent Beck
- Part of Extreme Programming (XP)
- Popularized in early 2000s
- Became core Agile engineering practice

TDD emerged to:

- Reduce bugs
- Improve design
- Enable fearless refactoring
- Increase development speed over time

---

# 3️⃣ The TDD Cycle (Deep Understanding)

## 🔴 RED

Write a test that fails.

- Defines expected behavior
- Forces clarity
- Prevents over-engineering

## 🟢 GREEN

Write the smallest possible code to pass the test.

- No extra logic
- No premature optimization
- Just enough to pass

## 🔵 REFACTOR

Improve:

- Naming
- Structure
- Design
- Duplication removal

All while tests remain green.

---

# 4️⃣ Why Practice TDD?

TDD forces:

✔ Better API design  
✔ Smaller methods  
✔ Decoupled architecture  
✔ High cohesion  
✔ Low coupling  
✔ Testable code

It prevents:

❌ God classes  
❌ Tight coupling  
❌ Hidden dependencies  
❌ Fear of refactoring

---

# 5️⃣ Types of Testing (Important for Interviews)

## Unit Testing

Testing individual classes in isolation.

## Integration Testing

Testing interaction between components.

## System Testing

Testing full application behavior.

## Acceptance Testing

Validating business requirements.

## Regression Testing

Ensuring new changes don't break old behavior.

## End-to-End Testing

Simulating real user workflows.

---

# 6️⃣ Testing Pyramid

        /\
       / UI \
      /------\
     /Integration\
    /------------\
    / Unit Tests  \
    /________________\

Best practice:

- More unit tests
- Fewer integration tests
- Minimal UI tests

Why?

- Unit tests are fast
- Integration tests are slower
- UI tests are expensive & brittle

---

# 7️⃣ Testing Frameworks & Tools

## Unit Testing

- JUnit
- TestNG

## Mocking

- Mockito
- EasyMock

## Assertion Libraries

- AssertJ
- Hamcrest

## Integration

- Spring Boot Test

## UI Testing

- Selenium
- Cypress

---

# 8️⃣ Core Testing Concepts

## Deterministic Tests

Always produce same result.

## Isolation

Test should not depend on:

- Database
- Network
- Other tests

## Idempotence

Test can run multiple times without side effects.

## Code Coverage

Percentage of code executed by tests.

⚠ 100% coverage ≠ bug-free code.

## Flaky Tests

Tests that pass/fail randomly.
Usually due to:

- Shared state
- Concurrency
- External dependencies

## Test Smells

- Too much setup
- Testing multiple behaviors
- Logic inside test
- Hard-coded values

---

# 9️⃣ Insights from TDD

TDD improves:

✔ API clarity  
✔ Error handling  
✔ Edge case coverage  
✔ Documentation quality

It changes mindset from:

"Does my code work?"

to

"What should this behavior be?"

---

# 🔟 When NOT to Use TDD

❌ Simple CRUD without logic  
❌ Throwaway scripts  
❌ Rapid prototypes  
❌ UI-heavy frontend experiments

TDD shines when:

- Business logic is complex
- Algorithms are involved
- Validation rules are strict

---

# 1️⃣1️⃣ Mocking Concepts (Preview for Next Module)

When unit testing:

We isolate class under test.

If class depends on:

- Database
- External API
- Payment gateway
- Email service

We replace dependency with:

👉 Test Double

Types of Test Doubles:

| Type  | Purpose                            |
|-------|------------------------------------|
| Dummy | Placeholder                        |
| Stub  | Returns fixed data                 |
| Mock  | Verifies interactions              |
| Spy   | Partial mock                       |
| Fake  | Lightweight working implementation |

Mockito helps create these.

---

# 1️⃣2️⃣ Interview Questions

Q: What is TDD cycle?  
Q: Benefits of TDD?  
Q: Difference between unit and integration testing?  
Q: What is test pyramid?  
Q: What is a flaky test?  
Q: Why is 100% coverage misleading?  
Q: When not to use TDD?

---