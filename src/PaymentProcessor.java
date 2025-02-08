public interface PaymentProcessor {
    boolean processPayment(String cardNumber, double amount);
}
