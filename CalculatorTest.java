import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testAddition() {
        Calculator calculator = new Calculator();
        assertEquals(10, calculator.add(7, 3));
    }

    @Test
    void testSubtraction() {
        Calculator calculator = new Calculator();
        assertEquals(4, calculator.subtract(9, 5));
    }

    @Test
    void testMultiplication() {
        Calculator calculator = new Calculator();
        assertEquals(15, calculator.multiply(3, 5));
    }

    @Test
    void testDivision() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.divide(10, 5));
    }

    @Test
    void testDivisionByZero() {
        Calculator calculator = new Calculator();
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }
}
