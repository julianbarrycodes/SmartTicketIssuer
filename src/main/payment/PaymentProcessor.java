package main.payment;

public interface PaymentProcessor {
    boolean processPayment(String cardNumber, double amount);
}
