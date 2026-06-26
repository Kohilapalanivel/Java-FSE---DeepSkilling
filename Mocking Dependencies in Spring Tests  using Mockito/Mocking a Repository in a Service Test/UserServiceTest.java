package mockitoPractice;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class UserServiceTest 
{
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;
    @Test
    public void testGetUserById() 
  {
        User user = new User();
        user.setId(1L);
        user.setName("Kohila");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        User result = userService.getUserById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Kohila", result.getName());
    }
}
