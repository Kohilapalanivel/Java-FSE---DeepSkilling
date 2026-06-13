import java.util.*;
class InventoryManager
{
    private HashMap<Integer, Product> inventory = new HashMap<>();
    public void addProduct(Product product) 
    {
        inventory.put(product.getProductId(), product);
        System.out.println("Product Added Successfully");
    }
    public void updateProduct(int id,String name,int quantity,double price)
    {
        if (inventory.containsKey(id)) 
        {
            Product p = inventory.get(id);
            p.setProductName(name);
            p.setQuantity(quantity);
            p.setPrice(price);
            System.out.println("Product Updated Successfully");
        } 
        else 
        {
            System.out.println("Product Not Found");
        }
    }
    public void deleteProduct(int id)
    {
        if (inventory.remove(id) != null) 
        {
            System.out.println("Product Deleted Successfully");
        } 
        else 
        {
            System.out.println("Product Not Found");
        }
    }
    public void displayProducts() 
    {
        if (inventory.isEmpty()) 
        {
            System.out.println("Inventory Empty");
            return;
        }
        for (Product p : inventory.values())
        {
            System.out.println(p);
        }
    }
}