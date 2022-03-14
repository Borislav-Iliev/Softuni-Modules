package ListyIterator;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> elements;
    private int index;

    public ListyIterator(List<String> elements) {
        this.elements = elements;
    }

    public boolean move() {
        if (this.index < this.elements.size() - 1) {
            this.index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.index < this.elements.size() - 1;
    }

    public void print() {
        if (this.elements.isEmpty()) {
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(this.elements.get(this.index));
        }
    }

    public void printAll() {
        this.elements.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                this.index++;
                return this.index < elements.size() - 1;
            }

            @Override
            public String next() {
                return elements.get(this.index++);
            }
        };
    }
}
