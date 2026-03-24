# 06 - Disabling Tests & Assumptions

---

# 1️⃣ Why Execution Control Matters

In real-world projects:

- Some tests run only in specific environments
- Some tests depend on OS
- Some tests depend on Java version
- Some tests must be temporarily disabled
- Some tests run only in CI

Without execution control:

- Builds fail unnecessarily
- Pipelines become unstable
- Platform-dependent issues arise

JUnit provides:
✔ Disabling mechanisms  
✔ Conditional execution  
✔ Assumptions

---

# 2️⃣ Disabling Tests

## @Disabled

Used to completely skip a test.

```java

@Disabled("Feature under development")
@Test
void testFeature() {
}
```

You can also disable entire class:

```java

@Disabled
class MyTest {
}
```

---

# 3️⃣ When to Use @Disabled

✔ Temporary feature under development  
✔ Known bug  
✔ External dependency unavailable  
✔ Performance-heavy tests

⚠ Do NOT leave disabled tests permanently.

---

# 4️⃣ Conditional Execution (Advanced)

JUnit 5 provides:

| Annotation                    | Condition                    |
|-------------------------------|------------------------------|
| @EnabledOnOs                  | Run only on specific OS      |
| @DisabledOnOs                 | Disable on specific OS       |
| @EnabledOnJre                 | Run on specific Java version |
| @EnabledIfEnvironmentVariable | Based on env variable        |
| @EnabledIfSystemProperty      | Based on system property     |

Example:

```java

@EnabledOnOs(OS.WINDOWS)
@Test
void runOnlyOnWindows() {
}
```

---

# 5️⃣ Assumptions

Assumptions are different from disabling.

If assumption fails:
👉 Test is skipped (not failed)

Used when:

- Environment not suitable
- External service unavailable
- Specific configuration missing

---

# 6️⃣ Basic Assumption Example

```java
import static org.junit.jupiter.api.Assumptions.*;

assumeTrue(condition);

assumeFalse(condition);
```

Example:

```java
assumeTrue(System.getenv("ENV") !=null);
```

If condition false → test aborted.

---

# 7️⃣ Difference: Disabled vs Assumption

| Feature        | @Disabled        | Assumption        |
|----------------|------------------|-------------------|
| When evaluated | Before execution | During execution  |
| Reason type    | Static           | Dynamic           |
| Typical usage  | Temporary skip   | Environment check |

---

# 8️⃣ Real-World Examples

✔ Run DB tests only in CI  
✔ Skip Windows-specific test on Linux  
✔ Run integration tests only in staging  
✔ Skip feature tests until implemented

---

# 9️⃣ CI/CD Impact

Assumptions help:

- Avoid pipeline failures
- Avoid false negatives
- Control environment-based execution

Very important in DevOps-heavy environments.

---

# 🔟 Interview Questions

Q: Difference between Disabled and Assumption?  
Q: What happens when assumption fails?  
Q: How to run test only on specific OS?  
Q: Can we disable entire class?  
Q: Does disabled test count as failure?

---

# 1️⃣1️⃣ Best Practices

✔ Always provide reason in @Disabled  
✔ Avoid long-term disabled tests  
✔ Use assumptions for environment checks  
✔ Avoid business logic in assumptions  
✔ Keep execution predictable

---

# 📌 Summary

Execution control enables:

- Stable builds
- Flexible test execution
- CI/CD compatibility
- Environment safety

Next:
07 - Repeating Tests & Dynamic Tests