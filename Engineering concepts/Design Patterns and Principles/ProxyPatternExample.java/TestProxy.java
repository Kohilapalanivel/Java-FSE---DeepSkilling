public class TestProxy 
{
    public static void main(String[] args) 
    {
        Image img = new ProxyImage("nature.jpg");
        img.display();
        System.out.println();
        img.display();
    }
}