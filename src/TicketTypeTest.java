import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicketTypeTest {
    @Test
    public void testTicketPrices() {
        assertEquals(2.20, TicketType.SINGLE_REDUCED.getPrice());
        assertEquals(3.20, TicketType.SINGLE_FULL.getPrice());
        assertEquals(5.50, TicketType.DAY_REDUCED.getPrice());
        assertEquals(7.90, TicketType.DAY_FULL.getPrice());
    }
}
