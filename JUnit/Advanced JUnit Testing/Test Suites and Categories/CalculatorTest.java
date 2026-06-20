package junitpractice;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest 
{
    Calculator calc = new Calculator();
    @Test
    void testAdd() {
        assertEquals(15, calc.add(10, 5));
    }
    @Test
    void testSubtract() {
        assertEquals(5, calc.subtract(10, 5));
    }
    @Test
    void testMultiply() {
        assertEquals(50, calc.multiply(10, 5));
    }
    @Test
    void testDivide() {
        assertEquals(2, calc.divide(10, 5));
    }
}
