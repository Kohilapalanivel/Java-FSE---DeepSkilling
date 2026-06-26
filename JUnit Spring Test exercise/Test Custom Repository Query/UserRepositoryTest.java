package mockitoPractice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest
{

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() 
    {

        userRepository.deleteAll();

        User user1 = new User();
        user1.setId(1L);
        user1.setName("Kohila");

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Kohila");

        User user3 = new User();
        user3.setId(3L);
        user3.setName("Rahul");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }

    @Test
    public void testFindByName() 
    {

        List<User> users = userRepository.findByName("Kohila");

        assertEquals(2, users.size());
        assertEquals("Kohila", users.get(0).getName());
    }
}
