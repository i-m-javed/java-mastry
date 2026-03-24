// Basic Interface
interface Payment {
    void pay(double amount);
}

// Second Interface
interface Refundable {
    void refund(double amount);
}

// Interface with default and static method
interface TransactionInfo {

    default void transactionType() {
        System.out.println("Online Transaction");
    }

    static void companyName() {
        System.out.println("FinTech Pvt Ltd");
    }
}

// Functional Interface
@FunctionalInterface
interface Notification {
    void sendMessage(String message);
}

// Class implementing multiple interfaces
class CreditCardPayment implements Payment, Refundable, TransactionInfo {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunded " + amount + " to Credit Card");
    }
}

class UpiPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

public class InterfaceDemo {

    public static void main(String[] args) {

        // Runtime Polymorphism
        Payment payment1 = new CreditCardPayment();
        payment1.pay(5000);

        Payment payment2 = new UpiPayment();
        payment2.pay(2000);

        // Accessing multiple interface methods
        CreditCardPayment cc = new CreditCardPayment();
        cc.refund(1000);
        cc.transactionType();

        // Static method from interface
        TransactionInfo.companyName();

        // Functional Interface (Lambda)
        Notification notification = (msg) ->
                System.out.println("Notification: " + msg);

        notification.sendMessage("Payment Successful");
    }
}