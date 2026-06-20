package junitpractice;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
public class StudentTest
{
    Student student;
    @BeforeEach
    void setUp() 
    {
        student = new Student();
    }
    @AfterEach
    void tearDown()
    {
        student = null;
    }
    @Test
    void testGrade() 
    {
        int mark = 80;
        String result = student.getGrade(mark);
        assertEquals("Pass", result); 
    }
}
