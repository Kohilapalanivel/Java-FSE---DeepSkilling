package junitpractice;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
@Suite
@SelectClasses({
        CalculatorTest.class,
        StudentTest.class
})
public class AllTests {

}
