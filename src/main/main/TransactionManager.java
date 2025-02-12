package main.main;

import main.ticketing.*;
import main.payment.*;
import main.utils.InputParser;
import java.util.Scanner;

/**
 * Manages the transaction process for ticket issuance and payment processing.
 * Ensures that the ticket is only issued after a successful payment.
 */
public class TransactionManager {

    /**
     * Scanner object for reading user input from the console.
     * Used for handling ticket and payment-related interactions.
     */
    private final Scanner scanner;

    /**
     * Initializes the TransactionManager with a TicketIssuer and a Scanner for user input.
     */
    public TransactionManager() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Starts the ticket purchasing process, ensuring payment is completed before issuing the ticket.
     */
    public void start() {
        System.out.println("Welcome to SmartTicketIssuer!");

        while (true) {
            // Step 1: Get ticket type
            TicketType ticketType = getUserTicketType();
            if (ticketType == null) break; // Exit if the user types EXIT

            // Step 2: Get the price of the selected ticket type
            double price = ticketType.getPrice();
            System.out.println("Selected Ticket: " + ticketType + " | Price: CHF" + price);

            // Step 3: Select payment method
            PaymentMethod paymentMethod = getUserPaymentMethod();
            if (paymentMethod == null) continue; // Restart if invalid or user quits

            // Step 4: Retrieve the appropriate payment processor from the factory
            PaymentProcessor processor;
            try {
                processor = PaymentProcessorFactory.createProcessor(paymentMethod);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue; // Restart if an unsupported payment method is chosen
            }

            // Step 5: Process payment
            String paymentInfo;
            while (true) {
                paymentInfo = getPaymentInfo(paymentMethod);
                if (paymentInfo == null) {
                    System.out.println("Restarting ticket purchase...");
                    break;
                }
                if (processor.processPayment(paymentInfo, price)) {
                    System.out.println("Payment successful! Issuing your ticket...");

                    // Step 6: Issue the ticket only after payment
                    TicketIssuer ticketIssuer = new TicketIssuer();
                    Ticket ticket = ticketIssuer.issueTicket(ticketType);
                    System.out.println("Ticket Issued: " + ticket.getTicketInfo());

                    return; // Exit after a successful transaction
                } else {
                    System.out.println("Payment failed. Try again or type EXIT to cancel.");
                }
            }
        }

        scanner.close();
        System.out.println("Application closed.");
    }

    /**
     * Prompts the user to select a ticket type.
     *
     * @return The selected TicketType or null if the user exits.
     */
    private TicketType getUserTicketType() {
        // Display available ticket types dynamically from the enum
        System.out.println("\nAvailable Ticket Types: ");
        for (TicketType type : TicketType.values()) {
            System.out.println("- " + type + " (CHF " + type.getPrice() + ")");
        }

        return getValidInput(
                TicketType::valueOf,
                "Enter ticket type (or type EXIT to quit): ",
                "Invalid ticket type! Please try again."
        );
    }

    /**
     * Prompts the user to select a payment method.
     *
     * @return The selected PaymentMethod or null if the user exits.
     */
    private PaymentMethod getUserPaymentMethod() {
        // Display available payment methods dynamically from the enum
        System.out.println("\nSelect a payment method: ");
        for (PaymentMethod method : PaymentMethod.values()) {
            System.out.println("- " + method);
        }

        return getValidInput(
                PaymentMethod::valueOf,
                "Enter payment method (or type EXIT to quit): ",
                "Invalid payment method! Please try again."
        );
    }

    /**
     * Prompts the user to enter payment details based on the selected method.
     *
     * @param method The selected payment method.
     * @return The user's input payment details or null if the user exits.
     */
    private String getPaymentInfo(PaymentMethod method) {
        String prompt;
        switch (method) {
            case CREDIT_CARD -> prompt = "Enter your card number (16 digits) or type EXIT to quit: ";
            case MOBILE_WALLET -> prompt = "Enter your mobile wallet ID (at least 6 alphanumeric characters) or type EXIT to quit: ";
            default -> throw new IllegalArgumentException("Unsupported payment method.");
        }

        return getValidInput(
                input -> {
                    if (input.equals("EXIT")) return null;
                    if (method == PaymentMethod.CREDIT_CARD && input.matches("\\d{16}")) return input;
                    if (method == PaymentMethod.MOBILE_WALLET && input.matches("[a-zA-Z0-9]{6,}")) return input;
                    throw new IllegalArgumentException("Invalid payment details.");
                },
                prompt,
                "Invalid input! Please try again."
        );
    }

    /**
     * A generic method to handle user input validation.
     *
     * @param parser       Function to parse input.
     * @param prompt       Prompt message for user input.
     * @param errorMessage Error message displayed on invalid input.
     * @param <T>          The type of input expected.
     * @return The parsed input or null if the user exits.
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
