package org.junit.TestInterfacesAndDefaultMethod;

public interface PaymentService {

    double process(double amount);

    boolean supportsCurrency(String currency);
}