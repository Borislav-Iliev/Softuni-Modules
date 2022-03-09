package GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public int compare(T element) {
        return (int) this.elements.stream()
                .filter(e -> e.compareTo(element) > 0)
                .count();
    }
}
