public class TestStrate
{
    public static void main(String[] args) 
    {
        PaymentStrategy card = new CreditCardPayment();
        PaymentContext context = new PaymentContext(card);
        context.executePayment(5000);
        PaymentStrategy paypal = new PayPalPayment();
        context = new PaymentContext(paypal);
        context.executePayment(2000);
    }
}