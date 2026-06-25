package mockitoPractice;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CalculatorServiceTest 
{
	CalculatorService calculatorService = new CalculatorService();
	@Test
	void  testAdd()
	{
		int result = calculatorService.add(1,2);
		assertEquals(3,result);
	}
}
