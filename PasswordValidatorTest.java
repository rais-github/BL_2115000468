import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValid("StrongPass1"), "Valid password should return true");
    }

    @Test
    void testShortPassword() {
        assertFalse(PasswordValidator.isValid("Short1"), "Password with less than 8 characters should return false");
    }

    @Test
    void testNoUppercaseLetter() {
        assertFalse(PasswordValidator.isValid("weakpassword1"), "Password without uppercase letter should return false");
    }

    @Test
    void testNoDigit() {
        assertFalse(PasswordValidator.isValid("NoDigitPass"), "Password without a digit should return false");
    }

    @Test
    void testNullPassword() {
        assertFalse(PasswordValidator.isValid(null), "Null password should return false");
    }
}
