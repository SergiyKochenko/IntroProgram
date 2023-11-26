package LibraryApplication;

import java.util.ArrayList;
import java.util.List;

// Book class implementing LibraryItem
class Book extends LibraryItem {
    private String author;
    private String ISBN;

    public Book(String title, String author, String ISBN) {
        super(title);
        this.author = author;
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
