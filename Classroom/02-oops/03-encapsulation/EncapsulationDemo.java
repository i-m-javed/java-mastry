class BankAccount {

    // Private variables (data hiding)
    private String accountHolder;
    private double balance;
    private final String bankCode = "IND001";  // read-only property

    // Constructor
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;

        if (initialBalance >= 0)
            this.balance = initialBalance;
        else
            this.balance = 0;
    }

    // Getter for account holder
    public String getAccountHolder() {
        return accountHolder;
    }

    // Getter for balance (read-only access)
    public double getBalance() {
        return balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method with validation
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
        }
    }

    // Getter for bankCode (read-only)
    public String getBankCode() {
        return bankCode;
    }
}

public class EncapsulationDemo {

    public static void main(String[] args) {

        BankAccount account = new BankAccount("Javed", 10000);

        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Initial Balance: " + account.getBalance());

        account.deposit(5000);
        System.out.println("After Deposit: " + account.getBalance());

        account.withdraw(3000);
        System.out.println("After Withdrawal: " + account.getBalance());

        account.withdraw(20000); // Invalid case

        System.out.println("Bank Code (Read-Only): " + account.getBankCode());

        // Direct access not allowed:
        // account.balance = 100000;  ❌ Error
    }
}