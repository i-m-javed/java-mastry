package org.junit.assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    @DisplayName("Order creation should initialize properly")
    void testOrderCreation() {

        Order order = new Order("ORD123", 1000);

        assertAll(
                () -> assertEquals("ORD123", order.getOrderId()),
                () -> assertEquals(1000, order.getAmount(), 0.01),
                () -> assertFalse(order.isProcessed())
        );
    }

    @Test
    @DisplayName("Processing should change state")
    void testProcessOrder() {

        Order order = new Order("ORD456", 500);

        order.process();

        assertTrue(order.isProcessed());
    }

    @Test
    @DisplayName("Processing twice should throw exception")
    void testDoubleProcessing() {

        Order order = new Order("ORD789", 300);
        order.process();

        IllegalStateException ex = assertThrows(
                IllegalStateException.class,
                order::process
        );

        assertEquals("Order already processed", ex.getMessage());
    }

    @Test
    @DisplayName("Invalid order creation should throw exception")
    void testInvalidOrder() {

        assertThrows(IllegalArgumentException.class,
                () -> new Order("", -10));
    }

    @Test
    @DisplayName("Processing should complete within timeout")
    void testProcessingTimeout() {

        Order order = new Order("ORD900", 100);

        assertTimeout(Duration.ofSeconds(1),
                order::process);
    }

    @Test
    @DisplayName("assertSame vs assertEquals demonstration")
    void testIdentity() {

        String a = "Hello";
        String b = "Hello";
        String c = new String("Hello");

        assertEquals(a, c);
        assertSame(a, b);
        assertNotSame(a, c);
    }
}


