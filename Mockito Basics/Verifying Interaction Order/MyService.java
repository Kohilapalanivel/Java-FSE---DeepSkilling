package mockitoPractice;
public class MyService
{
	private ExternalApi api;
    public MyService(ExternalApi api) 
    {
        this.api = api;
    }
    public void process() 
    {
        api.login();
        api.fetchData();
        api.logout();
    }
}
