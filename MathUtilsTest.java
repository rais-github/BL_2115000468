import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    @Test
    void testDivide() {
        MathUtils mathUtils = new MathUtils();
        assertEquals(5, mathUtils.divide(10, 2));
    }

    @Test
    void testDivideByZero() {
        MathUtils mathUtils = new MathUtils();
        Exception exception = assertThrows(ArithmeticException.class, () -> mathUtils.divide(10, 0));
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }
}
