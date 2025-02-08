import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicketIssuerTest {
    @Test
    public void testIssueSingleReducedTicket() {
        TicketIssuer issuer = new TicketIssuer();
        Ticket ticket = issuer.issueTicket(TicketType.SINGLE_REDUCED);
        assertNotNull(ticket); // Ensure ticket is created
        assertEquals(TicketType.SINGLE_REDUCED, ticket.getType()); // Ensure the correct type
    }

    @Test
    public void testIssueSingleFullTicket() {
        TicketIssuer issuer = new TicketIssuer();
        Ticket ticket = issuer.issueTicket(TicketType.SINGLE_FULL);
        assertNotNull(ticket);
        assertEquals(TicketType.SINGLE_FULL, ticket.getType());
    }

    @Test
    public void testIssueDayReducedTicket() {
        TicketIssuer issuer = new TicketIssuer();
        Ticket ticket = issuer.issueTicket(TicketType.DAY_REDUCED);
        assertNotNull(ticket);
        assertEquals(TicketType.DAY_REDUCED, ticket.getType());
    }

    @Test
    public void testIssueDayFullTicket() {
        TicketIssuer issuer = new TicketIssuer();
        Ticket ticket = issuer.issueTicket(TicketType.DAY_FULL);
        assertNotNull(ticket);
        assertEquals(TicketType.DAY_FULL, ticket.getType());
    }
}