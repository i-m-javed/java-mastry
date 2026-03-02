package org.junit.parameterizedTests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DiscountCalculatorTest {

    private final DiscountCalculator calculator = new DiscountCalculator();

    // ---------------------------
    // ValueSource Example
    // ---------------------------

    @ParameterizedTest
    @ValueSource(doubles = {100, 500, 1000})
    @DisplayName("Valid amount should not throw exception")
    void testValidAmounts(double amount) {
        assertDoesNotThrow(() -> calculator.applyDiscount(amount, 10));
    }

    // ---------------------------
    // CsvSource Example
    // ---------------------------

    @ParameterizedTest
    @CsvSource({
            "100, 10, 90",
            "200, 25, 150",
            "1000, 50, 500"
    })
    @DisplayName("Discount calculation validation")
    void testDiscountCalculation(double amount, double discount, double expected) {

        double result = calculator.applyDiscount(amount, discount);

        assertEquals(expected, result, 0.01);
    }

    // ---------------------------
    // Null and Empty Source
    // ---------------------------

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"abc12", "INVALID"})
    @DisplayName("Invalid coupons should return false")
    void testInvalidCoupons(String coupon) {
        assertFalse(calculator.isValidCoupon(coupon));
    }

    // ---------------------------
    // MethodSource (Advanced)
    // ---------------------------

    Stream<Arguments> provideInvalidDiscounts() {
        return Stream.of(
                Arguments.of(100, -10),
                Arguments.of(100, 150),
                Arguments.of(-100, 10)
        );
    }

    @ParameterizedTest
    @MethodSource("provideInvalidDiscounts")
    @DisplayName("Invalid inputs should throw exception")
    void testInvalidInputs(double amount, double discount) {

        assertThrows(IllegalArgumentException.class,
                () -> calculator.applyDiscount(amount, discount));
    }
}