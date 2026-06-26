package mockitoPractice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ParameterizedLoggingExample 
{
	private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);
    public static void main(String[] args) 
    {
        String userName = "Kohila";
        int age = 20;
        double cgpa = 8.55;
        logger.info("User Name: {}", userName);
        logger.info("Age: {}", age);
        logger.info("CGPA: {}", cgpa);
        logger.info("Student {} has a CGPA of {}", userName, cgpa);

    }
}
