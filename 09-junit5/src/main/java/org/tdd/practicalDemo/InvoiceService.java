package org.tdd.practicalDemo;

public class InvoiceService {

    private final TaxPolicy taxPolicy;

    public InvoiceService(TaxPolicy taxPolicy) {
        this.taxPolicy = taxPolicy;
    }

    public double calculate(double subtotal, double discount) {

        if (subtotal <= 0)
            throw new IllegalArgumentException("Subtotal must be positive");

        if (discount < 0 || discount > subtotal)
            throw new IllegalArgumentException("Invalid discount");

        double tax = taxPolicy.calculateTax(subtotal);

        return subtotal + tax - discount;
    }
}