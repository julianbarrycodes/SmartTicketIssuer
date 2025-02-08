package main.main;

import main.ticketing.Ticket;
import main.ticketing.TicketIssuer;
import main.ticketing.TicketType;

import java.util.Scanner;

public class Main {
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

        if (processor.processPayment(paymentInfo, ticket.getPrice())) {
            System.out.println("Payment processed. Enjoy your ride!");
        } else {
            System.out.println("Payment failed. main.ticketing.Ticket purchase canceled.");
        }

        scanner.close();
    }

    // Private helper method for safe parsing using lambda
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

