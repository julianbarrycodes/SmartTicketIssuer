package main.main;

/**
 * Launches the SmartTicketIssuer system.
 * This class initializes and starts the TransactionManager.
 */
public class Main {

    /**
     * Main method - the entry point of the application.
     * It creates and starts the TransactionManager, handling ticket transactions.
     *
     * @param args Command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        new TransactionManager().start();
    }
}
