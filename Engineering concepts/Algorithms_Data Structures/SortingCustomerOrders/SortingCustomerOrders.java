import java.util.*;
class Order
{
    int OderId;
    String CustomerName;
    double total_price;
    Order(int OderId,String CustomerName,double total_price)
    {
        this.OderId = OderId;
        this.CustomerName = CustomerName;
        this.total_price = total_price;
    }
    void display()
    {
        System.out.println("Order ID: "+ OderId + "\nCustomer Name: " + CustomerName + "\nTotal Price: " + total_price);
    }
}
public class SortingCustomerOrders
{
    public static void bubbleSort(Order arr[])
    {
        int n = arr.length;
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(arr[j].total_price > arr[j+1].total_price)
                {
                    Order temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    
    static int partition(Order arr[], int low, int high) {
        double pivot = arr[high].total_price;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].total_price < pivot) {
                i++;

                Order temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Order temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void quickSort(Order arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    public static void displayOrder(Order orders[])
    {
        for(Order order:orders)
        {
            order.display();
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        Order o1 = new Order(101, "Anu", 2500);
        Order o2 = new Order(107, "Arun", 1500);
        Order o3 = new Order(105, "Kohila", 4500);
        Order o4 = new Order(104, "David", 3000);
        Order orders[] = {o1,o2,o3,o4};
        System.out.println("1.Bubble sort");
        System.out.println("2.Quick sort");
        System.out.print("Enter the choice to sort(1 or 2): ");
        int choice = s.nextInt();
        switch(choice)
        {
            case 1:
                bubbleSort(orders);
                System.out.println("The Sorted Array by using Bubble Sort is: ");
                displayOrder(orders);
                break;
            case 2:
                quickSort(orders, 0, orders.length - 1);
                System.out.println("The Sorted Array by using Quick Sort is: ");
                displayOrder(orders);
                break;
            default:
                System.out.println("Invalid Choice!");
        }
    }
}
