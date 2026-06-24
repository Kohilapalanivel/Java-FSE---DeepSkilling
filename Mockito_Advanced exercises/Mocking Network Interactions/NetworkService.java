package mockitoPractice;
public class NetworkService 
{
	private NetworkClient client;
	public NetworkService(NetworkClient client)
	{
		this.client = client;
	}
	public String connectToServer()
	{
		return "Connected " + client.connect();
	}
}
