import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreditCardProcessorTest {

    @Test
    public void testValidCardNumber() {
        PaymentProcessor processor = new CreditCardProcessor();
        assertTrue(processor.processPayment("1234567812345678", 20.0)); // Valid card number
    }

    @Test
    public void testInvalidCardNumberShortLength() {
        PaymentProcessor processor = new CreditCardProcessor();
        assertFalse(processor.processPayment("12345", 20.0)); // Too short
    }

    @Test
    public void testInvalidCardNumberSpecialCharacters() {
        PaymentProcessor processor = new CreditCardProcessor();
        assertFalse(processor.processPayment("1234-5678-1234-5678", 20.0)); // Contains special characters
    }

    @Test
    public void testNullCardNumber() {
        PaymentProcessor processor = new CreditCardProcessor();
        assertFalse(processor.processPayment(null, 20.0)); // Null card number
    }

    @Test
    public void testZeroAmountPayment() {
        PaymentProcessor processor = new CreditCardProcessor();
        assertTrue(processor.processPayment("1234567812345678", 0.0)); // Valid card number with zero amount
    }
}