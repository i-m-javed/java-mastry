package org.junit.TestInterfacesAndDefaultMethod;

public class PaypalPaymentServiceTest implements PaymentServiceContractTest {

    @Override
    public PaymentService createService() {
        return new PaypalPaymentService();
    }
}