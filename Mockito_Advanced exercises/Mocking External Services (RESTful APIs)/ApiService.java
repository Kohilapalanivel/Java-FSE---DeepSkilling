package mockitoPractice;
public class ApiService
{
	private RestClient rest;
    public ApiService(RestClient rest) 
    {
        this.rest = rest;
    }
    public String fetchData() 
    {
        return "Fetched " + rest.getResponse();
    }
}
