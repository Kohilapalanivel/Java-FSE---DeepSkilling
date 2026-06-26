package mockitoPractice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class AppenderLoggingExample 
{
    private static final Logger logger = LoggerFactory.getLogger(AppenderLoggingExample.class);
    public static void main(String[] args) 
    {
        logger.debug("Debug message");
        logger.info("Information message");
        logger.warn("Warning message");
        logger.error("Error message");
    }
}
