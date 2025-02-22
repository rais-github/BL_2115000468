import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateFormatterTest {

    @Test
    void testValidDate() {
        assertEquals("15-08-2023", DateFormatter.formatDate("2023-08-15"), "Valid date should be formatted correctly");
        assertEquals("01-01-2000", DateFormatter.formatDate("2000-01-01"), "Valid date should be formatted correctly");
    }

    @Test
    void testInvalidDateFormat() {
        assertEquals("Invalid date format", DateFormatter.formatDate("15-08-2023"), "Incorrect input format should return error");
        assertEquals("Invalid date format", DateFormatter.formatDate("08/15/2023"), "Incorrect input format should return error");
        assertEquals("Invalid date format", DateFormatter.formatDate("2023/08/15"), "Incorrect input format should return error");
    }

    @Test
    void testEmptyOrNullInput() {
        assertEquals("Invalid date format", DateFormatter.formatDate(""), "Empty input should return error");
        assertEquals("Invalid date format", DateFormatter.formatDate(null), "Null input should return error");
    }
}
