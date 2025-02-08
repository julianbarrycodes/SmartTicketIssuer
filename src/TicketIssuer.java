import java.util.UUID;

public class TicketIssuer {
    public Ticket issueTicket(TicketType type) {
        String ticketId = UUID.randomUUID().toString().substring(0,8); // Generate a random ticket ID
        return new Ticket(ticketId, type);
    }

}
