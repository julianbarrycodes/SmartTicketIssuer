package main.ticketing;

/**
 * Represents different types of public transport tickets.
 *
 * <p>Each ticket type has a predefined price associated with it.</p>
 */
public enum TicketType {

    /**
     * A single reduced-fare ticket.
     */
    SINGLE_REDUCED(2.20),

    /**
     * A single full-fare ticket.
     */
    SINGLE_FULL(3.20),

    /**
     * A day pass with a reduced fare.
     */
    DAY_REDUCED(5.50),

    /**
     * A day pass with a full fare.
     */
    DAY_FULL(7.90);

    private final double price;

    /**
     * Constructs a {@code TicketType} with a specified price.
     *
     * @param price The price of the ticket type in CHF.
     */
    TicketType(double price) {
        this.price = price;
    }

    /**
     * Retrieves the price of the ticket.
     *
     * @return The price of the ticket type in CHF.
     */
    public double getPrice() {
        return price;
    }
}
