package org.junit.TestInterfacesAndDefaultMethod;

public class PaypalPaymentService implements PaymentService {

    @Override
    public double process(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        return amount + 5; // Flat fee
    }

    @Override
    public boolean supportsCurrency(String currency) {
        return "EUR".equalsIgnoreCase(currency);
    }
}