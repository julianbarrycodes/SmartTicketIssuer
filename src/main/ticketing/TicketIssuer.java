package main.ticketing;

import java.util.UUID;

/**
 * Handles the issuance of tickets.
 *
 * <p>This class is responsible for generating new tickets based on the specified
 * {@link TicketType}. Each ticket is assigned a unique ID upon creation.</p>
 */
public class TicketIssuer {

    /**
     * Issues a new ticket of the specified type.
     *
     * <p>A unique ticket ID is generated using {@link UUID}, and the corresponding
     * {@link Ticket} object is created with the given type.</p>
     *
     * @param type The type of ticket to be issued.
     * @return A new {@link Ticket} with a generated ID and the specified type.
     */
    public Ticket issueTicket(TicketType type) {
        String ticketId = UUID.randomUUID().toString().substring(0,8); // Generate a random ticket ID
        return new Ticket(ticketId, type);
    }

}
