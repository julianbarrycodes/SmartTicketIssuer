package main.main;

/**
 * Entry point for the SmartTicketIssuer system.
 * Initializes and starts the TransactionManager.
 */
public class Main {
    public static void main(String[] args) {
        new TransactionManager().start();
    }
}

