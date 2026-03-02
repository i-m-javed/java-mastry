package org.junit.nestedTests;

public class BankAccount {

    private double balance;
    private boolean active;

    public BankAccount(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.balance = balance;
        this.active = true;
    }

    public void deposit(double amount) {
        validateActive();
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        validateActive();
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
    }

    public void deactivate() {
        this.active = false;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }

    private void validateActive() {
        if (!active) {
            throw new IllegalStateException("Account is inactive");
        }
    }
}