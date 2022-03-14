package Library;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book b1, Book b2) {
        int sorted = b1.getTitle().compareTo(b2.getTitle());

        if (sorted == 0) {
            sorted = Integer.compare(b1.getYear(), b2.getYear());
        }

        return sorted;
    }
}
