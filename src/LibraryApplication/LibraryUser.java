package LibraryApplication;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// LibraryUser class
class LibraryUser {
    private String name;
    private String ID;
    private List<LibraryItem> borrowedAssets;

    public LibraryUser(String name, String ID) {
        this.name = name;
        this.ID = ID;
        this.borrowedAssets = new ArrayList<>();
    }

    public LibraryItem findBorrowedItem(String title) {
        for (LibraryItem item : borrowedAssets) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public List<LibraryItem> getBorrowedAssets() {
        return borrowedAssets;
    }

    public void setBorrowedAssets(List<LibraryItem> borrowedAssets) {
        this.borrowedAssets = borrowedAssets;
    }

    public void borrowAsset(LibraryItem asset) {
        borrowedAssets.add(asset);
    }

    public void returnAsset(LibraryItem asset) {
        borrowedAssets.remove(asset);
    }
}