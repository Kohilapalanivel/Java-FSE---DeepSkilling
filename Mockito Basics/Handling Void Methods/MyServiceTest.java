package mockitoPractice;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
public class MyServiceTest 
{
    @Test
    public void testVerifyInteraction() 
    {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        doNothing().when(mockApi).saveData("Hello Mockito");
        MyService service = new MyService(mockApi); 
        service.processData();
        verify(mockApi).saveData("Hello Mockito"); 
    }
}
