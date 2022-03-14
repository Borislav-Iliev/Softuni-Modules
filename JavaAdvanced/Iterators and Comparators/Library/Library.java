package Library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library implements Iterable<Book> {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void add(Book book) {
        this.books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    private class LibIterator implements Iterator<Book> {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < books.size();
        }

        @Override
        public Book next() {
            return books.get(counter++);
        }
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }
}
