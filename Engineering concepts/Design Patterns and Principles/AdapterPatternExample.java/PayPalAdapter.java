class PayPalAdapter implements PaymentProcessor 
{
    PayPalGateway payPal;
    public PayPalAdapter(PayPalGateway payPal) 
    {
        this.payPal = payPal;
    }
    public void processPayment(int amount) 
    {
        payPal.sendPayment(String.valueOf(amount));
    }
}