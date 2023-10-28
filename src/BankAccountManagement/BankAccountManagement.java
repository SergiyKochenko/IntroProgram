package BankAccountManagement;

import java.util.Scanner;

public class BankAccountManagement {
    public static void main(String[] args) {
        LinkedList accountList = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===============================");
            System.out.println("1. Add a new bank account");
            System.out.println("2. Deposit funds");
            System.out.println("3. Withdraw funds");
            System.out.println("4. Display account details");
            System.out.println("5. Remove account");
            System.out.println("6. Search for account");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accNum = scanner.nextLine();
                    System.out.print("Enter account holder name: ");
                    String accHolder = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    BankAccount newAccount = new BankAccount(accNum, accHolder, balance);
                    accountList.add(newAccount);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    String depositAccNum = scanner.nextLine();
                    BankAccount depositAccount = accountList.search(depositAccNum);
                    if (depositAccount != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    String withdrawAccNum = scanner.nextLine();
                    BankAccount withdrawAccount = accountList.search(withdrawAccNum);
                    if (withdrawAccount != null) {
                        try {
                            System.out.print("Enter amount to withdraw: ");
                            double withdrawAmount = scanner.nextDouble();
                            scanner.nextLine(); // Consume newline
                            withdrawAccount.withdraw(withdrawAmount);
                        } catch (InsufficientFundsException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    accountList.displayAccounts();
                    break;
                case 5:
                    System.out.print("Enter account number to remove: ");
                    String removeAccNum = scanner.nextLine();
                    accountList.remove(removeAccNum);
                    break;
                case 6:
                    System.out.print("Enter account number to search for: ");
                    String searchAccNum = scanner.nextLine();
                    BankAccount searchedAccount = accountList.search(searchAccNum);
                    if (searchedAccount != null) {
                        System.out.println("Account found: " + searchedAccount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
