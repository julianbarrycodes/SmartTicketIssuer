package test.payment;

import main.payment.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PaymentProcessorFactoryTest {

    // Test that the factory returns a CreditCardProcessor for CREDIT_CARD payment method
    @Test
    void testCreateProcessor_CreditCard() {
        PaymentProcessor processor = PaymentProcessorFactory.createProcessor(PaymentMethod.CREDIT_CARD);
        assertNotNull(processor, "Processor should not be null.");
        assertInstanceOf(CreditCardProcessor.class, processor, "Processor should be an instance of CreditCardProcessor.");
    }

    // Test that the factory returns a MobileWalletProcessor for MOBILE_WALLET payment method
    @Test
    void testCreateProcessor_MobileWallet() {
        PaymentProcessor processor = PaymentProcessorFactory.createProcessor(PaymentMethod.MOBILE_WALLET);
        assertNotNull(processor, "Processor should not be null.");
        assertInstanceOf(MobileWalletProcessor.class, processor, "Processor should be an instance of MobileWalletProcessor.");
    }

    // Test that the factory throws an exception when given a null payment method
    @Test
    @SuppressWarnings("ConstantConditions") // Suppresses warning for intentionally passing null
    void testCreateProcessor_NullMethod() {
        // This test ensures that the factory properly handles null input by throwing an exception
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                PaymentProcessorFactory.createProcessor(null) // Intentionally testing null input
        );

        assertEquals("Unsupported payment method: null", exception.getMessage());
    }
}
