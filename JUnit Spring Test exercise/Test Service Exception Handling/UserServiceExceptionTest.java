package mockitoPractice;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceExceptionTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testUserNotFound() {

        when(userRepository.findById(100L))
                .thenReturn(Optional.empty());

        User result = userService.getUserById(100L);

        assertNull(result);

        verify(userRepository, times(1)).findById(100L);
    }
}
