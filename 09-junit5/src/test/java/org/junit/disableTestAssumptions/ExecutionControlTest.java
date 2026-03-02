package org.junit.disableTestAssumptions;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class ExecutionControlTest {

    // ---------------------------
    // Disabled Test
    // ---------------------------

    @Test
    @Disabled("Feature not implemented yet")
    void disabledTest() {
        fail("This test should not run");
    }

    // ---------------------------
    // OS-Based Conditional Test
    // ---------------------------

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void runOnlyOnWindows() {
        assertTrue(System.getProperty("os.name").contains("Windows"));
    }

    @Test
    @DisabledOnOs(OS.LINUX)
    void disableOnLinux() {
        assertFalse(System.getProperty("os.name").contains("Linux"));
    }

    // ---------------------------
    // JRE-Based Conditional Test
    // ---------------------------

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void runOnlyOnJava17() {
        assertTrue(System.getProperty("java.version").startsWith("17"));
    }

    // ---------------------------
    // Environment Variable Based
    // ---------------------------

    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "DEV")
    void runOnlyInDevEnvironment() {
        assertNotNull(System.getenv("ENV"));
    }

    // ---------------------------
    // Assumption Example
    // ---------------------------

    @Test
    void assumptionExample() {

        assumeTrue(System.getenv("CI") != null,
                "Skipping test because not running in CI");

        assertTrue(true);
    }
}