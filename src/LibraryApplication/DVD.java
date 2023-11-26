package LibraryApplication;

import java.util.ArrayList;
import java.util.List;

// DVD class implementing LibraryItem
class DVD extends LibraryItem {
    private String director;
    private int releaseYear;

    public DVD(String title, String director, int releaseYear) {
        super(title);
        this.director = director;
        this.releaseYear = releaseYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}