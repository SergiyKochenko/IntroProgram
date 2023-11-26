package LibraryApplication;

import java.util.ArrayList;
import java.util.List;

// Interface for data management
interface DataManager<T> {
    void add(T item);
    void delete(T item);
    void update(T item);
    List<T> getAll();
}
