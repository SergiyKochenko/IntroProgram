package LibraryApplication;

import java.util.ArrayList;
import java.util.List;

// LibraryCatalog class to manage the library items
class LibraryCatalog {
    private List<Book> books;
    private List<DVD> dvds;
    private List<LibraryUser> users;

    public LibraryCatalog() {
        this.books = new ArrayList<>();
        this.dvds = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addDVD(DVD dvd) {
        dvds.add(dvd);
    }

    public void addUser(LibraryUser user) {
        users.add(user);
    }

    public void borrowAsset(LibraryItem asset, LibraryUser user) {
        asset.setAvailable(false);
        user.borrowAsset(asset);
    }

    public void returnAsset(LibraryItem asset, LibraryUser user) {
        asset.setAvailable(true);
        user.returnAsset(asset);
    }

    public void listAvailableBooks() {
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("%-35s%-35s%-15s%n", "Book Title", "Book Author", "ISBN");
        System.out.println("---------------------------------------------------------------------------");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.printf("%-35s%-35s%-15s%n", book.getTitle(), book.getAuthor(), book.getISBN());
            }
        }
        System.out.println("---------------------------------------------------------------------------");
    }

    public void listAvailableDVDs() {
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("%-35s%-35s%-10s%n", "DVD Title", "DVD Director", "Year");
        System.out.println("---------------------------------------------------------------------------");
        for (DVD dvd : dvds) {
            if (dvd.isAvailable()) {
                System.out.printf("%-35s%-35s%-10d%n", dvd.getTitle(), dvd.getDirector(), dvd.getReleaseYear());
            }
        }
        System.out.println("---------------------------------------------------------------------------");
    }

    public void listAssetsBorrowedByUser(LibraryUser user) {
        System.out.println("--------------------------------------");
        System.out.printf("User ID: %-10sUser Name: %-10s%n", user.getID(), user.getName());
        System.out.println("--------------------------------------");
        System.out.println(" Borrowed Assets");
        System.out.println();

        System.out.println("      Title:");
        for (LibraryItem item : user.getBorrowedAssets()) {
            System.out.println("         - " + item.getTitle());
        }

        System.out.println("--------------------------------------");
    }
    
    public LibraryItem findAvailableItem(String title) {
        for (LibraryItem item : books) {
            if (item.getTitle().equalsIgnoreCase(title) && item.isAvailable()) {
                return item;
            }
        }
        for (LibraryItem item : dvds) {
            if (item.getTitle().equalsIgnoreCase(title) && item.isAvailable()) {
                return item;
            }
        }
        return null;
    }

    public List<LibraryUser> getUsers() {
        return users;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<DVD> getDvds() {
        return dvds;
    }
}