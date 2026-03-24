package org.junit.assertions;

public class Order {

    private String orderId;
    private double amount;
    private boolean processed;

    public Order(String orderId, double amount) {

        if (orderId == null || orderId.isBlank()) {
            throw new IllegalArgumentException("Order ID cannot be empty");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        this.orderId = orderId;
        this.amount = amount;
        this.processed = false;
    }

    public void process() {
        if (processed) {
            throw new IllegalStateException("Order already processed");
        }
        simulateProcessingDelay();
        processed = true;
    }

    private void simulateProcessingDelay() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public String getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isProcessed() {
        return processed;
    }
}