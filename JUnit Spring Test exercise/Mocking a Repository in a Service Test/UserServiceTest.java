package mockitoPractice;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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
        assertEquals("Kohila", result.getName());
        assertEquals(1L, result.getId());
        verify(userRepository, times(1)).findById(1L);
    }
    @Test
    public void testGetUserById_UserNotFound() 
    {
        when(userRepository.findById(2L)).thenReturn(Optional.empty());
        User result = userService.getUserById(2L);
        assertNull(result);
        verify(userRepository, times(1)).findById(2L);
    }
}
