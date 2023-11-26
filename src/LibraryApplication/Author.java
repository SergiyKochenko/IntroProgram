package LibraryApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Author class
class Author {
    private String name;
    private List<Book> authoredBooks;

    public Author(String name) {
        this.name = name;
        this.authoredBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getAuthoredBooks() {
        return authoredBooks;
    }

    public void setAuthoredBooks(List<Book> authoredBooks) {
        this.authoredBooks = authoredBooks;
    }

    public void addAuthoredBook(Book book) {
        authoredBooks.add(book);
    }
}