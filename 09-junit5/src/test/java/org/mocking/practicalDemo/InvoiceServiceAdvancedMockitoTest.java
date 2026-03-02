package org.mocking.practicalDemo;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.tdd.practicalDemo.InvoiceService;
import org.tdd.practicalDemo.TaxPolicy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class InvoiceServiceAdvancedMockitoTest {

    @Mock
    TaxPolicy taxPolicy;

    @InjectMocks
    InvoiceService service;

    @Test
    void shouldCalculateUsingStubbedTaxPolicy() {

        when(taxPolicy.calculateTax(1000)).thenReturn(150.0);

        double result = service.calculate(1000, 50);

        assertEquals(1100, result);

        verify(taxPolicy, times(1)).calculateTax(1000);
    }

    @Test
    void shouldCaptureArgumentPassedToTaxPolicy() {

        when(taxPolicy.calculateTax(anyDouble())).thenReturn(200.0);

        service.calculate(2000, 100);

        ArgumentCaptor<Double> captor =
                ArgumentCaptor.forClass(Double.class);

        verify(taxPolicy).calculateTax(captor.capture());

        double captured = captor.getValue();

        assertEquals(2000, captured);
    }

    @Test
    void shouldThrowIfTaxPolicyFails() {

        when(taxPolicy.calculateTax(anyDouble()))
                .thenThrow(new RuntimeException("Tax engine down"));

        assertThrows(RuntimeException.class,
                () -> service.calculate(1000, 10));
    }
}