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

    /** Unique identifier for the ticket. */
    private final String id;

    /** The type of ticket, which determines its price and validity. */
    private final TicketType type;

    /** The price of the ticket, determined by its type. */
    private final double price;

    /** The timestamp of when the ticket was issued. */
    private final LocalDateTime issueDate;

    /**
     * Constructs a new ticket with a unique ID and a specified ticket type.
     *
     * <p>The ticket's price is determined by the {@link TicketType}, and the issue
     * date is automatically set to the current timestamp, truncated to minutes.</p>
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
     * Retrieves the formatted ticket details as a string.
     *
     * <p>The returned string includes the ticket ID, type, price (formatted to two decimal places),
     * and the issue date.</p>
     *
     * @return A formatted string containing ticket details.
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
