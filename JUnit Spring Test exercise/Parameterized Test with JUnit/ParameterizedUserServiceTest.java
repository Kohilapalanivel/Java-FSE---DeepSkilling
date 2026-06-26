package mockitoPractice;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParameterizedUserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 3L})
    public void testGetUserById(Long id) {

        User user = new User();
        user.setId(id);
        user.setName("Kohila");

        when(userRepository.findById(id))
                .thenReturn(Optional.of(user));

        User result = userService.getUserById(id);

        assertNotNull(result);
    }
}
