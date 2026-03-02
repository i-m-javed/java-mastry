package org.junit.lifecycle_testHierarchy;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LifecycleTest {

    int counter = 0;

    @BeforeAll
    void beforeAll() {
        System.out.println("Before All - Runs Once");
    }

    @AfterAll
    void afterAll() {
        System.out.println("After All - Runs Once");
    }

    @BeforeEach
    void beforeEach() {
        counter++;
        System.out.println("Before Each - Counter: " + counter);
    }

    @AfterEach
    void afterEach() {
        System.out.println("After Each");
    }

    @Test
    void testOne() {
        System.out.println("Test One");
        assertTrue(counter > 0);
    }

    @Test
    void testTwo() {
        System.out.println("Test Two");
        assertTrue(counter > 0);
    }

    @Nested
    class NestedContext {

        @BeforeEach
        void nestedBeforeEach() {
            System.out.println("Nested Before Each");
        }

        @Test
        void nestedTest() {
            System.out.println("Nested Test Execution");
            assertNotNull(counter);
        }
    }
}