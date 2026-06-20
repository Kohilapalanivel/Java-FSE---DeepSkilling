package junitpractice;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests
  {
    @Test
    @Order(1)
    void createUser() 
    {
        System.out.println("User Created");
    }

    @Test
    @Order(2)
    void updateUser() 
    {
        System.out.println("User Updated");
    }

    @Test
    @Order(3)
    void deleteUser() 
    {
        System.out.println("User Deleted");
    }
}
