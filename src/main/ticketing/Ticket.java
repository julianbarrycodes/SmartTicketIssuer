package main.ticketing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Represents a public transport ticket.
 *
 * <p>Each ticket has a unique ID, a specific type, a price, and an issue date.
 * The ticket type determines the price, and the issue date is automatically set
 * to the current date and time upon creation.</p>
 *
 * <p>Instances of this class are immutable, ensuring that ticket details remain
 * unchanged after creation.</p>
 */
public class Ticket {
    private final String id;
    private final TicketType type;
    private final double price;
    private final LocalDateTime issueDate;

    /**
     * Constructs a new ticket with a unique ID and a specified ticket type.
     *
     * <p>The ticket's price is determined by the {@link TicketType}, and the issue
     * date is automatically set to the current timestamp.</p>
     *
     * @param id   The unique identifier for the ticket.
     * @param type The type of ticket, which determines its price.
     */
    public Ticket(String id, TicketType type) {
        this.id = id;
        this.type = type;
        this.price = type.getPrice();
        this.issueDate = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
    }

    /**
     * Retrieves the formatted ticket details.
     *
     * @return A string containing the ticket ID, type, price, and issue date.
     */
    public String getTicketInfo() {
        return "Ticket ID: " + id +
                " | Type: " + type +
                " | Price: CHF " + String.format("%.2f", price) +
                " | Issued: " + issueDate;
    }

    /**
     * Gets the price of the ticket.
     *
     * @return The ticket price in CHF.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the type of the ticket.
     *
     * @return The ticket type.
     */
    public TicketType getType() {
        return type;
    }
}
