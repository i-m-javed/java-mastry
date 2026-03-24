package org.junit.nestedTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountNestedTest {

    BankAccount account;

    @BeforeEach
    void init() {
        account = new BankAccount(1000);
    }

    @Nested
    @DisplayName("When Account Is Active")
    class WhenAccountIsActive {

        @Test
        @DisplayName("Deposit should increase balance")
        void depositShouldIncreaseBalance() {
            account.deposit(500);
            assertEquals(1500, account.getBalance());
        }

        @Test
        @DisplayName("Withdraw should decrease balance")
        void withdrawShouldDecreaseBalance() {
            account.withdraw(400);
            assertEquals(600, account.getBalance());
        }

        @Test
        @DisplayName("Over-withdraw should throw exception")
        void overWithdrawShouldThrowException() {
            assertThrows(IllegalArgumentException.class,
                    () -> account.withdraw(2000));
        }
    }

    @Nested
    @DisplayName("When Account Is Inactive")
    class WhenAccountIsInactive {

        @BeforeEach
        void deactivateAccount() {
            account.deactivate();
        }

        @Test
        @DisplayName("Deposit should throw exception")
        void depositShouldFail() {
            assertThrows(IllegalStateException.class,
                    () -> account.deposit(100));
        }

        @Test
        @DisplayName("Withdraw should throw exception")
        void withdrawShouldFail() {
            assertThrows(IllegalStateException.class,
                    () -> account.withdraw(100));
        }
    }
}
