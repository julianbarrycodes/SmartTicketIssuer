import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {

    @Test
    void testTicketCreation() {
        Ticket ticket = new Ticket("1234", TicketType.SINGLE_FULL);

        assertEquals(TicketType.SINGLE_FULL, ticket.getType());
        assertEquals(3.20, ticket.getPrice());
    }

    @Test
    public void testGetTicketInfo() {
        Ticket ticket = new Ticket("1234", TicketType.DAY_FULL);
        String ticketInfo = ticket.getTicketInfo();
        assertTrue(ticketInfo.contains("Type: DAY_FULL"), "Ticket info should include the correct type.");
        System.out.println(ticketInfo);
        assertTrue(ticketInfo.contains("Price: CHF 7.90"), "Ticket info should include the correct price.");
    }
}
