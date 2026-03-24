package org.junit.introduction;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setup() {
        account = new BankAccount("Javed", 1000);
    }

    @Test
    @DisplayName("Deposit should increase balance")
    void testDeposit() {

        account.deposit(500);

        assertEquals(1500, account.getBalance());
    }

    @Test
    @DisplayName("Withdraw should decrease balance")
    void testWithdraw() {

        account.withdraw(400);

        assertEquals(600, account.getBalance());
    }

    @Test
    @DisplayName("Withdraw more than balance should throw exception")
    void testInsufficientBalance() {

        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(2000);
        });
    }

    @Test
    @DisplayName("Deposit negative amount should throw exception")
    void testInvalidDeposit() {

        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-100);
        });
    }

    @Test
    @DisplayName("Inactive account should not allow withdrawal")
    void testInactiveAccount() {

        account.deactivate();

        assertThrows(IllegalStateException.class, () -> {
            account.withdraw(100);
        });
    }

    @AfterEach
    void tearDown() {
        account = null;
    }
}