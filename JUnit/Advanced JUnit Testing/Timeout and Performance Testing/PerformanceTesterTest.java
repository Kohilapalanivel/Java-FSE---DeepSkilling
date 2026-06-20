package junitpractice;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import org.junit.jupiter.api.Test;

public class PerformanceTesterTest {

    @Test
    void testPerformance() {

        PerformanceTester pt = new PerformanceTester();

        assertTimeout(
                Duration.ofSeconds(2),
                () -> pt.performTask()
        );
    }
}
