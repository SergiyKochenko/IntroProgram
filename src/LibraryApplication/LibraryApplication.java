package LibraryApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main class for the library application
public class LibraryApplication {
    public static void main(String[] args) {
        LibraryCatalog libraryCatalog = new LibraryCatalog();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Book");
            System.out.println("2. Add DVD");
            System.out.println("3. List Available Books");
            System.out.println("4. List Available DVDs");
            System.out.println("5. Add User");
            System.out.println("6. Borrow Asset");
            System.out.println("7. Return Asset");
            System.out.println("8. List Borrowed Assets by User");
            System.out.println("9. Exit");
            System.out.print("Enter your choice (1-9): ");

            int choice = getValidChoice(scanner);

            switch (choice) {
                case 1:
                    addBook(libraryCatalog, scanner);
                    break;
                case 2:
                    addDVD(libraryCatalog, scanner);
                    break;
                case 3:
                    libraryCatalog.listAvailableBooks();
                    break;
                case 4:
                    libraryCatalog.listAvailableDVDs();
                    break;
                case 5:
                    addUser(libraryCatalog, scanner);
                    break;
                case 6:
                    borrowAsset(libraryCatalog, scanner);
                    break;
                case 7:
                    returnAsset(libraryCatalog, scanner);
                    break;
                case 8:
                    listBorrowedAssetsByUser(libraryCatalog, scanner);
                    break;
                case 9:
                    System.out.println("Exiting Library System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addBook(LibraryCatalog libraryCatalog, Scanner scanner) {
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        if (!title.matches("^[a-zA-Z ]+$")) {
            System.out.println("Invalid title! Only alphabetic characters and spaces are allowed.");
            return;
        }

        System.out.print("Enter Author: ");
        String author = scanner.nextLine();

        if (!author.matches("^[a-zA-Z ]+$")) {
            System.out.println("Invalid author! Only alphabetic characters and spaces are allowed.");
            return;
        }
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        if (!isbn.matches("^[0-9]+$")) {
            System.out.println("Invalid ISBN! Only numeric characters are allowed.");
            return;
        }

        Book newBook = new Book(title, author, isbn);
        libraryCatalog.addBook(newBook);
        System.out.println("Book added successfully!");
    }

    private static void addDVD(LibraryCatalog libraryCatalog, Scanner scanner) {
        System.out.print("Enter DVD Title: ");
        String title = scanner.nextLine();

        if (!title.matches("^[a-zA-Z ]+$")) {
            System.out.println("Invalid title! Only alphabetic characters and spaces are allowed.");
            return;
        }

        System.out.print("Enter Director: ");
        String director = scanner.nextLine();

        if (!director.matches("^[a-zA-Z ]+$")) {
            System.out.println("Invalid director! Only alphabetic characters and spaces are allowed.");
            return;
        }

        int releaseYear;
        while (true) {
            System.out.print("Enter Release Year (four or more digits): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a valid year.");
                scanner.next(); // Consume the invalid input
                continue;
            }
            releaseYear = scanner.nextInt();
            if (releaseYear < 1000) {
                System.out.println("Invalid year! Please enter a year with at least four digits.");
                continue;
            }
            break;
        }
        scanner.nextLine(); // Consume newline

        DVD newDVD = new DVD(title, director, releaseYear);
        libraryCatalog.addDVD(newDVD);
        System.out.println("DVD added successfully!");
    }

    private static void addUser(LibraryCatalog libraryCatalog, Scanner scanner) {
        System.out.print("Enter User Name: ");
        String userName = scanner.nextLine();

        if (!userName.matches("^[a-zA-Z ]+$")) {
            System.out.println("Invalid name! Only alphabetic characters and spaces are allowed.");
            return;
        }

        System.out.print("Enter User ID: ");
        String userID = scanner.nextLine();

        if (!userID.matches("^[0-9]+$")) {
            System.out.println("Invalid user ID! Only numeric characters are allowed.");
            return;
        }

        LibraryUser newUser = new LibraryUser(userName, userID);
        libraryCatalog.addUser(newUser);
        System.out.println("User added successfully!");
    }

    private static void borrowAsset(LibraryCatalog libraryCatalog, Scanner scanner) {
        System.out.print("Enter User ID: ");
        String borrowerID = scanner.nextLine();
        LibraryUser borrower = findUserByID(libraryCatalog, borrowerID);

        if (borrower == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.print("Enter Title of Asset to Borrow: ");
        String assetToBorrow = scanner.nextLine();

        LibraryItem itemToBorrow = libraryCatalog.findAvailableItem(assetToBorrow);
        if (itemToBorrow == null) {
            System.out.println("Asset not found or not available for borrowing!");
            return;
        }

        libraryCatalog.borrowAsset(itemToBorrow, borrower);
        System.out.println("Asset borrowed successfully!");
    }

    private static void returnAsset(LibraryCatalog libraryCatalog, Scanner scanner) {
        System.out.print("Enter User ID: ");
        String returnerID = scanner.nextLine();
        LibraryUser returner = findUserByID(libraryCatalog, returnerID);

        if (returner == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.print("Enter Title of Asset to Return: ");
        String assetToReturn = scanner.nextLine();

        LibraryItem itemToReturn = returner.findBorrowedItem(assetToReturn);
        if (itemToReturn == null) {
            System.out.println("Asset not found in user's borrowed list!");
            return;
        }

        libraryCatalog.returnAsset(itemToReturn, returner);
        System.out.println("Asset returned successfully!");
    }

    private static void listBorrowedAssetsByUser(LibraryCatalog libraryCatalog, Scanner scanner) {
        System.out.print("Enter User ID: ");
        String userIDToDisplay = scanner.nextLine();
        LibraryUser userToDisplay = findUserByID(libraryCatalog, userIDToDisplay);

        if (userToDisplay == null) {
            System.out.println("User not found!");
            return;
        }

        libraryCatalog.listAssetsBorrowedByUser(userToDisplay);
    }

    private static LibraryUser findUserByID(LibraryCatalog libraryCatalog, String userID) {
        for (LibraryUser user : libraryCatalog.getUsers()) {
            if (user.getID().equals(userID)) {
                return user;
            }
        }
        return null;
    }

    private static int getValidChoice(Scanner scanner) {
        int choice;
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // Consume the invalid input
                continue;
            }
            choice = scanner.nextInt();
            if (choice < 1 || choice > 9) {
                System.out.println("Invalid choice! Please enter a number between 1 and 9.");
                continue;
            }
            break;
        }
        scanner.nextLine(); // Consume newline
        return choice;
    }
}
