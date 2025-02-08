package test.payment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditCardProcessorTest {

    @Test
    public void testValidCardNumber() {
        PaymentProcessor processor = new CreditCardProcessor();
        Assertions.assertTrue(processor.processPayment("1234567812345678", 20.0)); // Valid card number
    }

    @Test
    public void testInvalidCardNumberShortLength() {
        PaymentProcessor processor = new CreditCardProcessor();
        Assertions.assertFalse(processor.processPayment("12345", 20.0)); // Too short
    }

    @Test
    public void testInvalidCardNumberSpecialCharacters() {
        PaymentProcessor processor = new CreditCardProcessor();
        Assertions.assertFalse(processor.processPayment("1234-5678-1234-5678", 20.0)); // Contains special characters
    }

    @Test
    public void testNullCardNumber() {
        PaymentProcessor processor = new CreditCardProcessor();
        Assertions.assertFalse(processor.processPayment(null, 20.0)); // Null card number
    }

    @Test
    public void testZeroAmountPayment() {
        PaymentProcessor processor = new CreditCardProcessor();
        Assertions.assertTrue(processor.processPayment("1234567812345678", 0.0)); // Valid card number with zero amount
    }
}