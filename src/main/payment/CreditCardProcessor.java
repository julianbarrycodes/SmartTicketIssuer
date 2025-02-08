package main.payment;

public class CreditCardProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(String cardNumber, double amount) {
        System.out.println("Processing payment of CHF " + amount + " from card: " + cardNumber);

        // Simulate successful payment (always true for simplicity)
        if (cardNumber != null && cardNumber.matches("\\d{16}")) { // Basic validation for a 16-digit card number
            System.out.println("Payment successful!");
            return true;
        } else {
            System.out.println("Payment failed. Invalid card number.");
            return false;
        }
    }
}
