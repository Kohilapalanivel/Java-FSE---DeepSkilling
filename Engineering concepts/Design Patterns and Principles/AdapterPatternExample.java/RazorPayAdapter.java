class RazorPayAdapter implements PaymentProcessor
{
    RazorPayGateway razorPay;
    public RazorPayAdapter(RazorPayGateway razorPay) 
    {
        this.razorPay = razorPay;
    }
    public void processPayment(int amount) 
    {
        razorPay.makeTransaction(amount);
    }
}