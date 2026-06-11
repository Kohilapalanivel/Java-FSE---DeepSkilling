public class TestAdapter {
    public static void main(String[] args) {

        PaymentProcessor p1 =
            new PayPalAdapter(new PayPalGateway());

        p1.processPayment(1000);

        PaymentProcessor p2 =
            new RazorPayAdapter(new RazorPayGateway());

        p2.processPayment(2000);
    }
}