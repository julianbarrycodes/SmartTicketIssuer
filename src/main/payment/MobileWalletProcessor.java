package main.payment;

/**
 * A payment processor that simulates processing payments through mobile wallets.
 * Implements the {@link PaymentProcessor} interface to handle payment logic.
 *
 * <p>This class validates the mobile wallet ID format and processes
 * payments by printing a confirmation message. For simplicity, all valid
 * wallet IDs simulate successful payments.</p>
 */

public class MobileWalletProcessor implements PaymentProcessor {
    /**
     * Processes a payment using a mobile wallet.
     *
     * @param walletId The mobile wallet ID as a string. Must be at least 6 alphanumeric characters to pass validation.
     * @param amount   The amount to be processed.
     * @return {@code true} if the payment is successful, {@code false} otherwise.
     */
    @Override
    public boolean processPayment(String walletId, double amount) {
        System.out.println("Processing payment of CHF " + amount + " from mobile wallet: " + walletId);

        // Simulate successful payment (always true for simplicity)
        if (walletId != null && walletId.matches("[A-Za-z0-9]{6,}")) {
            System.out.println("Payment successful!");
            return true;
        } else {
            System.out.println("Payment failed. Invalid wallet ID.");
            return false;
        }
    }
}
