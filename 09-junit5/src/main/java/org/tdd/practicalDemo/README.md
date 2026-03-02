# 02 - TDD Practical Demo
---

# 🎯 Goal

Build an InvoiceService using strict TDD.

We will:

1. Write failing tests
2. Implement minimal code
3. Refactor safely
4. Add new requirements
5. Improve design
6. Introduce dependency
7. Prepare for mocking (next module)

---

# 🧠 Business Requirements (Phase 1)

- Calculate total amount
- Formula:

  finalAmount = subtotal + tax - discount

Rules:

- subtotal must be > 0
- tax must be >= 0
- discount must be >= 0
- discount cannot exceed subtotal

---

# 🔴 Step 1 — RED

Write first failing test:

- Verify correct calculation
- No validations yet

---

# 🟢 Step 2 — GREEN

Implement minimal logic.

No over-engineering.
No unnecessary fields.

---

# 🔵 Step 3 — REFACTOR

Clean:

- Extract validation
- Improve naming
- Remove duplication

---

# 🔴 Step 4 — Add Validation Tests

Now add:

- Negative subtotal
- Excess discount
- Negative tax

Watch them fail.

---

# 🟢 Step 5 — Implement Validation

Make tests pass.

---

# 🔵 Step 6 — Refactor Structure

- Extract validation method
- Improve cohesion
- Keep method small

---

# 🔴 Step 7 — Introduce Dependency

New requirement:

- Tax calculation depends on TaxPolicy

Now design change is required.

TDD forces us to:

- Extract interface
- Inject dependency
- Avoid tight coupling

This is where good architecture emerges.

---

# 🧠 Learning Outcome

TDD forces:
✔ Cleaner APIs  
✔ Better abstractions  
✔ Dependency injection  
✔ Testable design  
✔ Low coupling

You design better because tests demand it.

---
