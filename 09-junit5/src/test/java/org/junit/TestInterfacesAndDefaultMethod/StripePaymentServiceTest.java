package org.junit.TestInterfacesAndDefaultMethod;


public class StripePaymentServiceTest implements PaymentServiceContractTest {

    @Override
    public PaymentService createService() {
        return new StripePaymentService();
    }
}