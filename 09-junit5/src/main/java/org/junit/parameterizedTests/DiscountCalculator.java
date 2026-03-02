package org.junit.parameterizedTests;

public class DiscountCalculator {

    public double applyDiscount(double amount, double discountPercent) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Invalid discount percentage");
        }

        return amount - (amount * discountPercent / 100);
    }

    public boolean isValidCoupon(String coupon) {
        return coupon != null && coupon.matches("^[A-Z]{3}\\d{2}$");
    }
}