package app.src.main.java;

public interface PaymentProcessor {
    public void processPayment(double amount);
    public void checkPaymentStatus(Order order);
}
