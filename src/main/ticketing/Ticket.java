package main.ticketing;

import java.time.LocalDateTime;

public class Ticket {
    private final String id;
    private final TicketType type;
    private final double price;
    private final LocalDateTime issueDate;

    public Ticket(String id, TicketType type) {
        this.id = id;
        this.type = type;
        this.price = type.getPrice();
        this.issueDate = LocalDateTime.now();
    }

    public String getTicketInfo() {
        return "main.ticketing.Ticket ID: " + id +
                " | Type: " + type +
                " | Price: CHF " + String.format("%.2f", price) +
                " | Issued: " + issueDate;
    }

    public double getPrice() {
        return price;
    }

    public TicketType getType() {
        return type;
    }
}
