import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicketIssuerTest {
    @Test
    void testIssueTicket() {
        TicketIssuer issuer = new TicketIssuer();
        Ticket ticket = issuer.issueTicket(TicketType.SINGLE_FULL);

        assertNotNull(ticket.getTicketInfo());  // Ensure ticket is created
    }
}