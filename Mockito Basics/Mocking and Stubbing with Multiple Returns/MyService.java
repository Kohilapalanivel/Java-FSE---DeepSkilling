package mockitoPractice;
public class MyService 
{
	private ExternalApi api;
    public MyService(ExternalApi api) 
    {
        this.api = api;
    }
    public String getFinalStatus() 
    {
        String status1 = api.fetchStatus();
        String status2 = api.fetchStatus();
        String status3 = api.fetchStatus();
        return status3;
     }
}
