public class PayPalPayment.java implements PaymentStrategy 
{
    public void pay(int amount) 
    {
        System.out.println("Paid Rs." + amount +" using PayPal");
    }
}