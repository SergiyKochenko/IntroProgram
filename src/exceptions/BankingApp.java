package exceptions;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class BankingApp {
    private static ArrayList<BankAccount> accounts = new ArrayList<>();
    private static final String FILE_NAME = "accounts.ser";

    public static void main(String[] args) {
        loadAccounts();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Create Account");
            System.out.println("2. Select Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");

            int choice = getValidChoice(scanner, 1, 6);

            switch (choice) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    selectAccount(scanner);
                    break;
                case 3:
                    deposit(scanner);
                    break;
                case 4:
                    withdraw(scanner);
                    break;
                case 5:
                    checkBalance();
                    break;
                case 6:
                    exit = true;
                    break;
            }
        }

        saveAccounts();
    }

    private static int getValidChoice(Scanner scanner, int min, int max) {
        int choice = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                if (choice < min || choice > max) {
                    throw new InputMismatchException();
                }

                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                scanner.nextLine(); // Clear the buffer
            }
        }

        return choice;
    }

    private static void createAccount(Scanner scanner) {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        accounts.add(new BankAccount(accountNumber));
        System.out.println("Account created successfully.");
    }

    private static void selectAccount(Scanner scanner) {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        BankAccount selectedAccount = getAccount(accountNumber);

        if (selectedAccount != null) {
            System.out.println(selectedAccount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void deposit(Scanner scanner) {
        BankAccount selectedAccount = getSelectedAccount(scanner);

        if (selectedAccount != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            selectedAccount.deposit(amount);
        }
    }

    private static void withdraw(Scanner scanner) {
        BankAccount selectedAccount = getSelectedAccount(scanner);

        if (selectedAccount != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();

            try {
                selectedAccount.withdraw(amount);
            } catch (InsufficientFundsException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void checkBalance() {
        BankAccount selectedAccount = getSelectedAccount(new Scanner(System.in));

        if (selectedAccount != null) {
            System.out.println("Current balance: " + selectedAccount.getBalance());
        }
    }

    private static BankAccount getSelectedAccount(Scanner scanner) {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        BankAccount selectedAccount = getAccount(accountNumber);

        if (selectedAccount == null) {
            System.out.println("Account not found.");
        }

        return selectedAccount;
    }

    private static BankAccount getAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    private static void loadAccounts() {
        try {
            FileInputStream fileIn = new FileInputStream(FILE_NAME);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            accounts = (ArrayList<BankAccount>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            // No saved accounts, continue with empty list
        }
    }

    private static void saveAccounts() {
        try {
            FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(accounts);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
