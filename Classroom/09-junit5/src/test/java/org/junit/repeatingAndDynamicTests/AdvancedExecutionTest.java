package org.junit.repeatingAndDynamicTests;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestFactory;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdvancedExecutionTest {

    private Random random = new Random();

    // ---------------------------
    // Repeated Test
    // ---------------------------

    @RepeatedTest(value = 5,
            name = "Random validation - Run {currentRepetition}/{totalRepetitions}")
    void testRandomNumberGeneration(RepetitionInfo repetitionInfo) {

        int number = random.nextInt(100);

        System.out.println("Run: " + repetitionInfo.getCurrentRepetition()
                + " -> Generated: " + number);

        assertTrue(number >= 0 && number < 100);
    }

    // ---------------------------
    // Dynamic Tests
    // ---------------------------

    @TestFactory
    Stream<DynamicTest> dynamicDiscountValidation() {

        double[] amounts = {100, 200, 300, 400};

        return Stream.of(amounts)
                .map(amount ->
                        DynamicTest.dynamicTest(
                                "Discount validation for amount: " + amount,
                                () -> {
                                    double discount = amount * 0.10;
                                    assertEquals(amount * 0.10, discount, 0.01);
                                }
                        )
                );
    }

    // ---------------------------
    // Dynamic Test From Complex Object
    // ---------------------------

    @TestFactory
    Stream<DynamicTest> dynamicStringValidation() {

        return Stream.of("JAVA", "JUNIT", "TEST")
                .map(str ->
                        DynamicTest.dynamicTest(
                                "Validate uppercase string: " + str,
                                () -> assertTrue(str.equals(str.toUpperCase()))
                        )
                );
    }
}