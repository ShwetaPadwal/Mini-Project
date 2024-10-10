package ServiceBank;

import java.util.ArrayList;
import java.util.List;
import EntityBank.*;
import Exception.InsufficientFundsException;

public class BankingService {

    private List<Account> accounts;

    public BankingService() {  // Corrected: Removed void return type, properly declared constructor
        this.accounts = new ArrayList<>();
    }

    public void createAccount(Customer customer) {
        String accountNumber = "ACC" + (accounts.size() + 1);
        Account account = new Account(accountNumber, customer);
        accounts.add(account);
        System.out.println("Account created: " + account);
    }

    public void deposit(String accountNumber, double amount) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.deposit(amount);
                System.out.println("Deposited $" + amount + " to account " + accountNumber);
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public void withdraw(String accountNumber, double amount) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                try {
                    account.withdraw(amount);
                    System.out.println("Withdrew $" + amount + " from account " + accountNumber);
                } catch (InsufficientFundsException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public void saveAllAccountsToFile(String filename) {
        for (Account account : accounts) {
            account.saveAccountToFile(filename);  // Now using filename parameter
        }
    }

    public void displayAllAccounts() {
        System.out.println("\n--- All Accounts ---");
        for (Account account : accounts) {
            System.out.println(account);
            System.out.println("Balance: $" + account.getBalance());
        }
    }
}
