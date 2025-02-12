# SmartTicketIssuer

## Project Overview

**SmartTicketIssuer** is a Java-based ticketing system that simulates public transport ticket purchases, including dynamic ticket issuance and payment processing. The system follows **Object-Oriented Programming (OOP)** principles and uses a **modular architecture** for maintainability and scalability.

## Features

- **Dynamic Ticket Issuance** – Users can select different ticket types.
- **Payment Processing** – Supports Credit Card and Mobile Wallet payments.
- **Robust Error Handling** – Ensures valid user input and handles incorrect entries gracefully.
- **Extensible Design** – Uses Factory Pattern to allow adding new payment methods easily.
- **Separation of Concerns** – `TransactionManager` orchestrates processes, keeping `Main` clean.

## Project Structure



SmartTicketIssuer/
- src/
    - main/
        - main/
            - Main.java
            - TransactionManager.java
        - ticketing/
            - Ticket.java
            - TicketIssuer.java
            - TicketType.java
        - payment/
            - PaymentProcessor.java
            - CreditCardProcessor.java
            - MobileWalletProcessor.java
            - PaymentProcessorFactory.java
            - PaymentMethod.java
        - utils/
            - InputParser.java
    - test/
        - payment/
            - PaymentProcessorFactoryTest.java

## How to Run the Project

1.  Clone the Repository
```sh
   git clone https://github.com/julianbarrycodes/SmartTicketIssuer
```
2.  Compile the Project
```sh
    javac src/main/**/*.java -d out
```
3.  Run the Application
```sh
    java -cp out main.main.Main
```  

## Usage Instructions

1. **Start the program** – The system will prompt you to select a ticket type.
2. **Choose a ticket** – You will see available options (e.g., `SINGLE_FULL`, `DAY_REDUCED`).
3. **Select payment method** – Choose **Credit Card** or **Mobile Wallet**.
4. **Enter payment details** – The system validates the input.
5. **Receive your ticket** – Once payment is successful, your ticket details (including an ID) will be displayed.
6. **Type `"EXIT"` at any prompt** to cancel the transaction.

---

## Key Technologies Used

- **Java** – Core language.
- **OOP Principles** – Encapsulation, Polymorphism, and Abstraction.
- **Factory Pattern** – For flexible payment processor creation.
- **JUnit** – For unit testing.
- **Error Handling** – Ensures valid input and recovery from incorrect entries.

---

## Testing

- This project includes **unit tests** to ensure robust functionality.

- To run the tests:
```sh
java -jar junit-platform-console-standalone.jar --class-path out --scan-classpath
``` 

## Future Improvements

- Add More Payment Methods (e.g., **PayPal, Apple Pay**).
- Integrate with **Real APIs** for live transactions.
- Implement a **Database** to store user transactions.
- Enhance **Ticket Pricing Rules** (e.g., dynamic fares, discounts).

---

## Author

**Julian Barry**  
📧 Email: [contact.julian.barry@gmail.com](mailto:contact.julian.barry@gmail.com)  
🔗 LinkedIn: [linkedin.com/in/julianbarry](https://linkedin.com/in/julianbarry)

