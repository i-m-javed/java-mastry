package org.junit.TestInterfacesAndDefaultMethod;

public class StripePaymentService implements PaymentService {

    @Override
    public double process(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        return amount + (amount * 0.02); // 2% processing fee
    }

    @Override
    public boolean supportsCurrency(String currency) {
        return "USD".equalsIgnoreCase(currency);
    }
}