import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicketTypeTest {
    @Test
    public void testSingleReducedPrice() {
        assertEquals(2.20, TicketType.SINGLE_REDUCED.getPrice());
    }

    @Test
    public void testSingleFullPrice() {
        assertEquals(3.20, TicketType.SINGLE_FULL.getPrice());
    }

    @Test
    public void testDayReducedPrice() {
        assertEquals(5.50, TicketType.DAY_REDUCED.getPrice());
    }

    @Test
    public void testDayFullPrice() {
        assertEquals(7.90, TicketType.DAY_FULL.getPrice());
    }
}
