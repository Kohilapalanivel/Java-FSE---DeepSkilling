package junitpractice;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class ExceptionThrowerTest 
{
    @Test
    void testException() 
    {
        ExceptionThrower obj = new ExceptionThrower();
        assertThrows( ArithmeticException.class,() -> obj.throwException());

    }
}
