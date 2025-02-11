package main.main;

import main.ticketing.*;
import main.payment.*;
import main.utils.InputParser;
import java.util.Scanner;

/**
 * Manages the full transaction flow for purchasing tickets.
 * Handles user input, ticket selection, payment processing, and error handling.
 * <p>
 * This class is responsible for:
 * <ul>
 *     <li>Prompting users to select a ticket type.</li>
 *     <li>Issuing the selected ticket.</li>
 *     <li>Prompting users to select a payment method.</li>
 *     <li>Processing payments and handling failures.</li>
 * </ul>
 * <p>
 * It delegates ticket issuing to {@link TicketIssuer} and payment processing to {@link PaymentProcessor}.
 */
public class TransactionManager {
    private final TicketIssuer ticketIssuer;
    private final Scanner scanner;

    /**
     * Constructs a new TransactionManager and initializes required components.
     */
    public TransactionManager() {
        this.ticketIssuer = new TicketIssuer();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Starts the ticket purchasing process.
     * Manages the main loop, handling user interactions and transaction flow.
     */
    public void start() {
        try {
            System.out.println("Welcome to SmartTicketIssuer!");

            while (true) {
                TicketType ticketType = getUserTicketType();
                if (ticketType == null) break; // User chose to exit

                Ticket ticket = ticketIssuer.issueTicket(ticketType);
                System.out.println("Ticket Issued: " + ticket.getTicketInfo());

                PaymentMethod paymentMethod = getUserPaymentMethod();
                if (paymentMethod == null) continue; // Restart if invalid

                PaymentProcessor processor;
                try {
                    processor = PaymentProcessorFactory.createProcessor(paymentMethod);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    continue; // Restart if unsupported payment method
                }

                processPayment(processor, ticket);
            }
        } finally {
            scanner.close();
            System.out.println("Application closed.");
        }
    }

    /**
     * Prompts the user to select a ticket type.
     *
     * @return the selected {@link TicketType}, or {@code null} if the user exits.
     */
    private TicketType getUserTicketType() {
        System.out.println("\nAvailable Ticket Types: SINGLE_REDUCED, SINGLE_FULL, DAY_REDUCED, DAY_FULL");
        return getValidInput(TicketType::valueOf, "Enter ticket type (or type EXIT to quit): ", "Invalid ticket type! Please try again.");
    }

    /**
     * Prompts the user to select a payment method.
     *
     * @return the selected {@link PaymentMethod}, or {@code null} if the user exits.
     */
    private PaymentMethod getUserPaymentMethod() {
        System.out.println("\nSelect payment method: CREDIT_CARD, MOBILE_WALLET");
        return getValidInput(PaymentMethod::valueOf, "Enter payment method (or type EXIT to quit): ", "Invalid payment method! Please try again.");
    }

    /**
     * Handles payment processing and retries if the payment fails.
     *
     * @param processor the {@link PaymentProcessor} responsible for handling the transaction.
     * @param ticket    the {@link Ticket} being purchased.
     */
    private void processPayment(PaymentProcessor processor, Ticket ticket) {
        while (true) {
            String paymentInfo = getPaymentInfo(processor);
            if (paymentInfo == null) {
                System.out.println("Restarting ticket purchase...");
                return;
            }
            if (processor.processPayment(paymentInfo, ticket.getPrice())) {
                System.out.println("Payment processed. Enjoy your ride!");
                return;
            } else {
                System.out.println("Payment failed. Try again or type EXIT to cancel.");
            }
        }
    }

    /**
     * Prompts the user for payment details and validates input based on the selected payment method.
     *
     * @param processor the {@link PaymentProcessor} being used for the transaction.
     * @return the validated payment information, or {@code null} if the user exits.
     */
    private String getPaymentInfo(PaymentProcessor processor) {
        String prompt = switch (processor.getClass().getSimpleName()) {
            case "CreditCardProcessor" -> "Enter your card number (16 digits) or type EXIT to quit: ";
            case "MobileWalletProcessor" -> "Enter your mobile wallet ID (at least 6 alphanumeric characters) or type EXIT to quit: ";
            default -> throw new IllegalArgumentException("Unsupported payment method.");
        };

        return getValidInput(input -> {
            if (input.equals("EXIT")) return null;
            if (processor instanceof CreditCardProcessor && input.matches("\\d{16}")) return input;
            if (processor instanceof MobileWalletProcessor && input.matches("[a-zA-Z0-9]{6,}")) return input;
            throw new IllegalArgumentException("Invalid payment details.");
        }, prompt, "Invalid input! Please try again.");
    }

    /**
     * A helper method for safely parsing user input with validation.
     *
     * @param parser      the {@link InputParser} used to parse the input.
     * @param prompt      the message displayed to prompt the user.
     * @param errorMessage the error message displayed if validation fails.
     * @param <T>         the type of input expected.
     * @return the parsed and validated user input, or {@code null} if the user exits.
     */
    private <T> T getValidInput(InputParser<T> parser, String prompt, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("EXIT")) return null;
            try {
                return parser.parse(input);
            } catch (IllegalArgumentException e) {
                System.out.println(errorMessage);
            }
        }
    }
}
