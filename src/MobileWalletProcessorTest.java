import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MobileWalletProcessorTest {

    @Test
    public void testValidWallerId() {
        PaymentProcessor processor = new MobileWalletProcessor();
        assertTrue(processor.processPayment("wallet123", 10.0)); // Valid waller ID
    }
    @Test
    public void testInvalidWalletIdShortLength() {
        PaymentProcessor processor = new MobileWalletProcessor();
        assertFalse(processor.processPayment("123", 10.0)); // Too short
    }

    @Test
    public void testInvalidWalletIdSpecialCharacters() {
        PaymentProcessor processor = new MobileWalletProcessor();
        assertFalse(processor.processPayment("wallet$123", 10.0)); // Contains special characters
    }

    @Test
    public void testNullWalletId() {
        PaymentProcessor processor = new MobileWalletProcessor();
        assertFalse(processor.processPayment(null, 10.0)); // Null wallet ID
    }

    @Test
    public void testZeroAmountPayment() {
        PaymentProcessor processor = new MobileWalletProcessor();
        assertTrue(processor.processPayment("wallet123", 0.0)); // Valid wallet ID with zero amount
    }
}
