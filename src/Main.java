import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicketIssuer ticketIssuer = new TicketIssuer();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to SmartTicketIssuer!");
        System.out.println("Available Ticket Types: SINGLE_REDUCED, SINGLE_FULL, DAY_REDUCED, DAY_FULL");

        //User selects ticket type
        System.out.print("Enter ticket type: ");
        String ticketTypeInput = scanner.nextLine().toUpperCase();
        TicketType ticketType;

        try {
            ticketType = TicketType.valueOf(ticketTypeInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid ticket type! Please enter a valid ticket type.");
            return;
        }

        // Issue ticket
        TicketIssuer issuer = new TicketIssuer();
        Ticket ticket = issuer.issueTicket(ticketType);
        System.out.println("Ticket Issued: " + ticket.getTicketInfo());

        // Process payment
        System.out.print("Enter your card number (16 digits): ");
        String cardNumber = scanner.nextLine();

        if (PaymentProcessor.processPayment(cardNumber, ticket.getPrice())) {
            System.out.println("Payment processed. Enjoy your ride!");
        } else {
            System.out.println("Payment failed. Ticket purchase canceled.");
        }

        scanner.close();
    }
}