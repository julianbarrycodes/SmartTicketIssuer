public class MobileWalletProcessor implements PaymentProcessor {
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
