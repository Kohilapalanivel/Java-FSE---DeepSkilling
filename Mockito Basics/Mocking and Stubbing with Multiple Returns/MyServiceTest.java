package mockitoPractice;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
public class MyServiceTest 
{
    @Test
    public void testMultipleReturns() 
    {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.fetchStatus()).thenReturn("DATA_PENDING").thenReturn("DATA_READY").thenReturn("COMPLETED");
        MyService service = new MyService(mockApi);
        String result = service.getFinalStatus();
        assertEquals("COMPLETED", result);
        verify(mockApi, times(3)).fetchStatus();
    }
}
