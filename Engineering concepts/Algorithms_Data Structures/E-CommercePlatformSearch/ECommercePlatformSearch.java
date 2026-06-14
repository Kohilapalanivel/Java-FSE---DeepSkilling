import java.util.*;
class Product
{
    int ProductId;
    String ProductName;
    String Category;
    Product(int ProductID,String ProductName,String Category)
    {
        this.ProductId = ProductID;
        this.ProductName = ProductName;
        this.Category = Category;
    }
    public void display()
    {
        System.out.println("ProductId: "+ProductId + "\nProduct Name: "+ ProductName + "\nCategory: "+Category);
    }
}
public class ECommercePlatformSearch
{
    public static Product linearSearch(Product products[] , int target)
    {
        for(Product product:products)
        {
            if(product.ProductId == target)
            {
                return product;
            }
        }
        return null;
    }
    public static Product binarSearch(Product products[],int target)
    {
        int left = 0;
        int right = products.length - 1;
        while(left <= right)
        {
            int mid = left + ((right - left)/2);
            if(products[mid].ProductId == target)
            {
                return products[mid];
            }
            else if(products[mid].ProductId > target)
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }
        return null;
    }
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the ProductId to Searched: ");
        int search = s.nextInt();
        System.out.println();
        Product p1 = new Product(101,"Laptop","Electronics");
        Product p2 = new Product(104,"Mouse","Electronics");
        Product p3 = new Product(107,"Watch","Accessories");
        Product p4 = new Product(102,"Shoes","Fashion");
        Product products[] = {p1,p2,p3,p4};
        Product result_linear = linearSearch(products,search);
        Product result_Binary = binarSearch(products,search);
        System.out.print("Enter the type of search function(1 for Linear Search and 2 for Binary Search): ");
        int search_function = s.nextInt();
        switch(search_function)
        {
            case 1:
                System.out.println("Linear Search ..");
                if(result_linear == null)
                {
                    System.out.println("Product Not Found!");
                }
                else
                {
                    System.out.println("Product Found!");
                    result_linear.display();
                }
                break;
            case 2:
                System.out.println("Binary Search..");
                if(result_Binary == null)
                {
                    System.out.println("Product Not Found!");
                }
                else
                {
                    System.out.println("Product Found!");
                    result_Binary.display();
                }
                break;
            default:
                System.out.println("Invalid Operation!");
                break;
        }
    }
}
