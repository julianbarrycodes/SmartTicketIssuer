package main.payment;

/**
 * Factory class for creating {@link PaymentProcessor} instances based on the given {@link PaymentMethod}.
 */
public class PaymentProcessorFactory {

    /**
     * Creates a {@link PaymentProcessor} based on the specified {@link PaymentMethod}.
     *
     * @param method the {@link PaymentMethod} for which the processor is to be created.
     * @return the appropriate {@link PaymentProcessor} instance.
     * @throws IllegalArgumentException if the {@code method} is {@code null} or unsupported.
     */
    public static PaymentProcessor createProcessor(PaymentMethod method) {
        if (method == null) {
            throw new IllegalArgumentException("Unsupported payment method: null");
        }

        switch (method) {
            case CREDIT_CARD:
                return new CreditCardProcessor();
            case MOBILE_WALLET:
                return new MobileWalletProcessor();
            default:
                throw new IllegalArgumentException("Unsupported payment method: " + method);
        }
    }
}
