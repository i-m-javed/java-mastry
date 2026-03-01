import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Custom Checked Exception
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Custom Unchecked Exception
class InvalidTransactionException extends RuntimeException {
    public InvalidTransactionException(String message) {
        super(message);
    }
}

class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {

        if (amount <= 0) {
            throw new InvalidTransactionException("Amount must be positive");
        }

        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: " + balance);
    }
}

public class ExceptionHandling {

    public static void main(String[] args) {

        System.out.println("==== CUSTOM EXCEPTION DEMO ====");
        customExceptionDemo();

        System.out.println("\n==== TRY-WITH-RESOURCES DEMO ====");
        tryWithResourcesDemo();

        System.out.println("\n==== PROPAGATION DEMO ====");
        propagationDemo();
    }

    private static void customExceptionDemo() {

        BankAccount account = new BankAccount(5000);

        try {
            account.withdraw(7000);
        } catch (InsufficientBalanceException e) {
            System.out.println("Checked Exception: " + e.getMessage());
        }

        try {
            account.withdraw(-100);
        } catch (InvalidTransactionException | InsufficientBalanceException e) {
            System.out.println("Unchecked Exception: " + e.getMessage());
        }
    }

    private static void tryWithResourcesDemo() {

        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {

            String line = br.readLine();
            System.out.println(line);

        } catch (IOException e) {
            System.out.println("Handled IOException safely.");
        }
    }

    private static void propagationDemo() {

        try {
            methodA();
        } catch (Exception e) {
            System.out.println("Exception propagated to main.");
        }
    }

    private static void methodA() throws Exception {
        methodB();
    }

    private static void methodB() throws Exception {
        throw new Exception("Exception from methodB");
    }
}