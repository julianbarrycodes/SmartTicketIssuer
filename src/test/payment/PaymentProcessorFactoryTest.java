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

}
