package LibraryApplication;

import java.util.ArrayList;
import java.util.List;

// LibraryItem abstract class
abstract class LibraryItem {
    private String title;
    private boolean isAvailable;

    public LibraryItem(String title) {
        this.title = title;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}