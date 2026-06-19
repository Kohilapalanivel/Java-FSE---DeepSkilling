package junitpractice;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class CalculatorTest 
{
	@Test
	void testAdd() 
  {
        Calculator c = new Calculator();
        assertEquals(5, c.add(2,3));
    }
}
