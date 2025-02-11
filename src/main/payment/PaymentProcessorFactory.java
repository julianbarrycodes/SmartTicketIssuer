package main.payment;

import org.jetbrains.annotations.NotNull;

/**
 * Factory class for creating {@link PaymentProcessor} instances based on the given {@link PaymentMethod}.
 */
public class PaymentProcessorFactory {

    /**
     * Creates a {@link PaymentProcessor} based on the specified {@link PaymentMethod}.
     *
     * @param method the {@link PaymentMethod} for which the processor is to be created.
     * @return the appropriate {@link PaymentProcessor} instance.
     * @throws IllegalArgumentException if the {@code method} is unsupported.
     */
    public static PaymentProcessor createProcessor(@NotNull PaymentMethod method) {
        return switch (method) {
            case CREDIT_CARD -> new CreditCardProcessor();
            case MOBILE_WALLET -> new MobileWalletProcessor();
            default -> throw new IllegalArgumentException("Unsupported payment method: " + method);
        };
    }
}