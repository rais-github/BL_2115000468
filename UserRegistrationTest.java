import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {

    @Test
    void testValidRegistration() {
        assertDoesNotThrow(() -> UserRegistration.registerUser("JohnDoe", "john@example.com", "Password123"));
    }

    @Test
    void testEmptyUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                UserRegistration.registerUser("", "user@example.com", "Password123"));
        assertEquals("Username cannot be empty", exception.getMessage());
    }

    @Test
    void testInvalidEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                UserRegistration.registerUser("JohnDoe", "invalid-email", "Password123"));
        assertEquals("Invalid email format", exception.getMessage());
    }

    @Test
    void testInvalidPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                UserRegistration.registerUser("JohnDoe", "john@example.com", "pass"));
        assertEquals("Password must be at least 8 characters, contain one uppercase letter, and one digit", exception.getMessage());
    }

    @Test
    void testNullInputs() {
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser(null, "user@example.com", "Password123"));
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("JohnDoe", null, "Password123"));
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("JohnDoe", "user@example.com", null));
    }
}
