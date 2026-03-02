package org.junit.introduction;

public class BankAccount {

    private String accountHolder;
    private double balance;
    private boolean active;

    public BankAccount(String accountHolder, double initialBalance) {

        if (accountHolder == null || accountHolder.isBlank()) {
            throw new IllegalArgumentException("Account holder name cannot be empty");
        }

        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }

        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.active = true;
    }

    public void deposit(double amount) {

        if (!active) {
            throw new IllegalStateException("Account is inactive");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }

        balance += amount;
    }

    public void withdraw(double amount) {

        if (!active) {
            throw new IllegalStateException("Account is inactive");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
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
}
