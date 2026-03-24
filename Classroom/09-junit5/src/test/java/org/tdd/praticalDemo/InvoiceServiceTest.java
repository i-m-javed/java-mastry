package org.tdd.praticalDemo;



/*
-> Write first test (RED)
-> Run fails :  InvoiceService does not exist
-> PHASE 1 — Minimal Implementation (GREEN)
-> Run pass : minimal
-> Phase 2 - add validation test
-> run fails : not write in main class
-> PHASE 2 — Add Validation (GREEN)
-> run pass
-> PHASE 2 — REFACTOR : Extract validation method
-> Tests still pass → Safe refactoring.
-> PHASE 3 — Introduce TaxPolicy Dependency
    New Requirement: Tax should be calculated by separate TaxPolicy.
    Write test first:


 */

import org.junit.jupiter.api.Test;
import org.tdd.practicalDemo.InvoiceService;
import org.tdd.practicalDemo.TaxPolicy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InvoiceServiceTest {

    @Test
    void shouldCalculateFinalAmountUsingTaxPolicy() {
        TaxPolicy policy = amount -> amount * 0.10;
        InvoiceService service = new InvoiceService(policy);

        double result = service.calculate(1000, 50);

        assertEquals(1050, result);
    }

    @Test
    void negativeSubtotalShouldThrowException() {
        TaxPolicy policy = amount -> amount * 0.10;
        InvoiceService service = new InvoiceService(policy);

        assertThrows(IllegalArgumentException.class,
                () -> service.calculate(-100, 50));
    }

    @Test
    void discountGreaterThanSubtotalShouldThrowException() {
        TaxPolicy policy = amount -> amount * 0.10;
        InvoiceService service = new InvoiceService(policy);

        assertThrows(IllegalArgumentException.class,
                () -> service.calculate(100, 200));
    }
}