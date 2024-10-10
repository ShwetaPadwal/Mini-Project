package EntityBank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Exception.InsufficientFundsException;

public class Account {
    private String accountNumber;
    private Customer customer;
    private double balance;
    private List<Transaction> transactions;  // Corrected: Changed from Transcation to Transaction

    public Account(String accountNumber, Customer customer) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));  // Corrected: Changed from Transcation to Transaction
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
        balance -= amount;
        transactions.add(new Transaction("Withdrawal", amount));  // Corrected: Changed from Transcation to Transaction
    }

    public void saveAccountToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {  // Now using filename
            writer.write(this.toString());
            writer.newLine();
            writer.write("Balance: $" + balance);
            writer.newLine();
            writer.write("Transactions:");
            writer.newLine();
            for (Transaction transaction : transactions) {  // Corrected: Changed from Transcation to Transaction
                writer.write(transaction.toString());
                writer.newLine();
            }
            writer.write("-------------------------");
            writer.newLine();
            System.out.println("Account saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving account: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return customer + " (Account Number: " + accountNumber + ")";
    }
}
