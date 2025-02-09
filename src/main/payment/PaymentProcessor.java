package main.payment;

/**
 * An interface for processing payments.
 *
 * <p>Defines a standard method for handling payments, allowing different
 * payment methods (e.g., credit card, mobile wallet) to implement their
 * own payment processing logic.</p>
 */
public interface PaymentProcessor {

    /**
     * Processes a payment transaction.
     *
     * @param paymentInfo The payment identifier (e.g., credit card number or mobile wallet ID).
     * @param amount      The amount to be processed.
     * @return {@code true} if the payment is successful, {@code false} otherwise.
     */
    boolean processPayment(String paymentInfo, double amount);
}
