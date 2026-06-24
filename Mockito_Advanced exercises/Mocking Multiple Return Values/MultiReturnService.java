package mockitoPractice;
public class MultiReturnService 
{
	private Repository repo;
    public MultiReturnService(Repository repo) 
    {
        this.repo = repo;
    }
    public String processData() 
    {
        return "Processed " + repo.getData();
    }
}
