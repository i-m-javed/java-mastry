package org.mocking.fundamentals;

import org.junit.jupiter.api.Test;
import org.tdd.practicalDemo.InvoiceService;
import org.tdd.practicalDemo.TaxPolicy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class InvoiceServiceMockitoTest {

    @Test
    void shouldCalculateUsingMockedTaxPolicy() {

        // Create mock
        TaxPolicy mockPolicy = mock(TaxPolicy.class);

        // Stub behavior
        when(mockPolicy.calculateTax(1000)).thenReturn(200.0);

        InvoiceService service = new InvoiceService(mockPolicy);

        double result = service.calculate(1000, 50);

        // Assert final amount
        assertEquals(1150, result);

        // Verify interaction
        verify(mockPolicy).calculateTax(1000);
    }
}