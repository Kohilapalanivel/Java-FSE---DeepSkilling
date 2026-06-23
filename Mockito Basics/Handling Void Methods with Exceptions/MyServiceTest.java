package mockitoPractice;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
public class MyServiceTest 
{
    @Test
    public void testVoidMethodThrowsException() 
    {
        ExternalApi mockApi = mock(ExternalApi.class);
        doThrow(new RuntimeException("API Failed")).when(mockApi).saveData("Hello Mockito");
        MyService service = new MyService(mockApi);
        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            service.process();
        });
        assertEquals("API Failed", ex.getMessage());
        verify(mockApi).saveData("Hello Mockito");
    }
}
