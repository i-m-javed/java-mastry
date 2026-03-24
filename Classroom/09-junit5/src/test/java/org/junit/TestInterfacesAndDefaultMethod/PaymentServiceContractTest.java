package org.junit.TestInterfacesAndDefaultMethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public interface PaymentServiceContractTest {

    PaymentService createService();

    @Test
    default void processShouldIncreaseAmount() {
        PaymentService service = createService();
        double result = service.process(100);
        assertTrue(result > 100);
    }

    @Test
    default void negativeAmountShouldThrowException() {
        PaymentService service = createService();

        assertThrows(IllegalArgumentException.class,
                () -> service.process(-10));
    }

    @Test
    default void unsupportedCurrencyShouldReturnFalse() {
        PaymentService service = createService();
        assertFalse(service.supportsCurrency("INR"));
    }
}