package org.tdd.fundamentals;

/*
write first
run this
it fails (RED)
Because Calculator doesn’t exist yet.
then make the Calculator
that is TDD
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void shouldAddTwoNumbers() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }
}