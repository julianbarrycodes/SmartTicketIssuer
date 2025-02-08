package test.ticketing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.ticketing.Ticket;
import main.ticketing.TicketType;

public class TicketTest {

    @Test
    void testTicketCreation() {
        Ticket ticket = new Ticket("1234", TicketType.SINGLE_FULL);

        Assertions.assertEquals(TicketType.SINGLE_FULL, ticket.getType());
        Assertions.assertEquals(3.20, ticket.getPrice());
    }

    @Test
    public void testGetTicketInfo() {
        Ticket ticket = new Ticket("1234", TicketType.DAY_FULL);
        String ticketInfo = ticket.getTicketInfo();
        assertTrue(ticketInfo.contains("Type: DAY_FULL"), "main.ticketing.Ticket info should include the correct type.");
        System.out.println(ticketInfo);
        assertTrue(ticketInfo.contains("Price: CHF 7.90"), "main.ticketing.Ticket info should include the correct price.");
    }
}
