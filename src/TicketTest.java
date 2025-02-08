import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {

    @Test
    void testTicketCreation() {
        Ticket ticket = new Ticket("1234", TicketType.SINGLE_FULL);

        assertEquals(TicketType.SINGLE_FULL, ticket.getType());
        assertEquals(3.20, ticket.getPrice());
    }
}
