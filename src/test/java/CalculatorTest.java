import org.example.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testAddition() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    void testSubtraction() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(5, 2);
        assertEquals(3, result);
    }
}