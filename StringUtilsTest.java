import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {

    @Test
    void testReverse() {
        StringUtils utils = new StringUtils();
        assertEquals("olleH", utils.reverse("Hello"));
        assertEquals("", utils.reverse(""));
        assertEquals("a", utils.reverse("a"));
        assertNull(utils.reverse(null));
    }

    @Test
    void testIsPalindrome() {
        StringUtils utils = new StringUtils();
        assertTrue(utils.isPalindrome("madam"));
        assertFalse(utils.isPalindrome("hello"));
        assertTrue(utils.isPalindrome("racecar"));
        assertFalse(utils.isPalindrome(null));
    }

    @Test
    void testToUpperCase() {
        StringUtils utils = new StringUtils();
        assertEquals("HELLO", utils.toUpperCase("hello"));
        assertEquals("WORLD", utils.toUpperCase("world"));
        assertNull(utils.toUpperCase(null));
    }
}
