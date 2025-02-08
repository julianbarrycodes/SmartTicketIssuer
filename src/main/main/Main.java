package main.main;

import main.ticketing.*;
import main.payment.*;
import main.utils.InputParser;
import java.util.Scanner;

/**
 * The entry point for the SmartTicketIssuer application.
 *
 * <p>This class integrates ticketing and payment functionalities, simulating
 * a ticket issuing and payment processing system for public transport.
 * Users can select a ticket type, issue a ticket, and complete payment using
 * either a credit card or a mobile wallet.</p>
 *
 * <p>The main method orchestrates the flow, including:</p>
 * <ul>
 *     <li>Prompting the user to select a ticket type.</li>
 *     <li>Issuing the ticket.</li>
 *     <li>Selecting a payment method (credit card or mobile wallet).</li>
 *     <li>Processing the payment and providing feedback.</li>
 * </ul>
 */
public class Main {

    /**
     * The main entry point of the application.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        TicketIssuer ticketIssuer = new TicketIssuer();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to SmartTicketIssuer!");
        System.out.println("Available main.ticketing.Ticket Types: SINGLE_REDUCED, SINGLE_FULL, DAY_REDUCED, DAY_FULL");

        TicketType ticketType = safeParse(TicketType::valueOf, scanner, "Enter ticket type: ");
        if (ticketType == null) return;

        // Issue ticket
        Ticket ticket = ticketIssuer.issueTicket(ticketType);
        System.out.println("main.ticketing.Ticket Issued: " + ticket.getTicketInfo());

        // Choose payment method
        System.out.println("Select payment method: CREDIT_CARD, MOBILE_WALLET");
        PaymentMethod paymentMethod = safeParse(PaymentMethod::valueOf, scanner, "Enter payment method: ");
        if (paymentMethod == null) return;

        // Assign correct payment processor
        PaymentProcessor processor;
        String paymentInfo;

        if (paymentMethod == PaymentMethod.CREDIT_CARD) {
            processor = new CreditCardProcessor();
            System.out.print("Enter your card number (16 digits): ");
            paymentInfo = scanner.nextLine();
        } else {
            processor = new MobileWalletProcessor();
            System.out.print("Enter your mobile wallet ID (at least 6 alphanumeric characters): ");
            paymentInfo = scanner.nextLine();
        }

        // Process payment
        if (processor.processPayment(paymentInfo, ticket.getPrice())) {
            System.out.println("Payment processed. Enjoy your ride!");
        } else {
            System.out.println("Payment failed. main.ticketing.Ticket purchase canceled.");
        }

        scanner.close();
    }

    /**
     * A private helper method for safely parsing user input using lambdas.
     *
     * <p>This method prompts the user, reads input, and attempts to parse it
     * into the desired type. If parsing fails, it returns {@code null} and
     * displays an error message.</p>
     *
     * @param parser The {@link InputParser} instance to parse the input.
     * @param scanner The {@link Scanner} to read user input.
     * @param prompt A prompt message to display to the user.
     * @param <T> The type to parse the input into.
     * @return The parsed input of type {@code T}, or {@code null} if parsing fails.
     */
    private static <T> T safeParse(InputParser<T> parser, Scanner scanner, String prompt) {
        System.out.print(prompt);
        try {
            return parser.parse(scanner.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input! Please try again.");
            return null;
        }
    }
}

