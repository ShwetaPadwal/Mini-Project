package Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import EntityBank.*;
import ServiceBank.*;

public class TestBank {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BankingService bankingService = new BankingService();  // Corrected constructor invocation

        try {
            // Create accounts
            System.out.print("How many accounts do you want to create? ");
            int numberOfAccounts = Integer.parseInt(reader.readLine());

            for (int i = 0; i < numberOfAccounts; i++) {
                System.out.println("\n--- Account " + (i + 1) + " ---");

                // Get customer details
                System.out.print("Enter customer name: ");
                String customerName = reader.readLine();
                System.out.print("Enter customer contact: ");
                String customerContact = reader.readLine();
                Customer customer = new Customer(customerName, customerContact);

                // Create account
                bankingService.createAccount(customer);
            }

            // Perform transactions
            while (true) {
                System.out.print("\nDo you want to deposit or withdraw (d/w)? (or 'exit' to finish): ");
                String action = reader.readLine();
                if (action.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.print("Enter account number: ");
                String accountNumber = reader.readLine();
                System.out.print("Enter amount: ");
                double amount = Double.parseDouble(reader.readLine());

                if (action.equalsIgnoreCase("d")) {
                    bankingService.deposit(accountNumber, amount);
                } else if (action.equalsIgnoreCase("w")) {
                    bankingService.withdraw(accountNumber, amount);
                } else {
                    System.out.println("Invalid action. Please enter 'd' or 'w'.");
                }
            }

            // Save all accounts to file
            bankingService.saveAllAccountsToFile("accounts.txt");

            // Display all accounts
            bankingService.displayAllAccounts();

        } catch (NumberFormatException e) {
            System.out.println("Invalid input: Please enter numeric values for account count and amount.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
