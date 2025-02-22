import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(100.0); // Initial balance of 100
    }

    @Test
    void testDeposit() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), "Balance should be updated correctly after deposit");
    }

    @Test
    void testWithdraw() {
        account.withdraw(40.0);
        assertEquals(60.0, account.getBalance(), "Balance should be updated correctly after withdrawal");
    }

    @Test
    void testWithdrawInsufficientFunds() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(200.0), "Should throw exception if funds are insufficient");
    }

    @Test
    void testNegativeDeposit() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-10.0), "Should not allow negative deposits");
    }

    @Test
    void testNegativeWithdraw() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-10.0), "Should not allow negative withdrawals");
    }
}
