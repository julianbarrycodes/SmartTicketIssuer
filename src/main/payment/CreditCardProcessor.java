package main.payment;

/**
 * A payment processor that simulates processing credit card payments.
 * Implements the {@link PaymentProcessor} interface to handle payment logic.
 *
 * <p>This class validates the credit card number format (16 digits) and processes
 * payments by printing a confirmation message. For simplicity, all valid credit
 * card numbers simulate successful payments.</p>
 */
public class CreditCardProcessor implements PaymentProcessor {

    /**
     * Processes a credit card payment.
     *
     * @param cardNumber The credit card number as a string. Must be 16 digits to pass validation.
     * @param amount     The amount to be processed.
     * @return {@code true} if the payment is successful, {@code false} otherwise.
     */
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
