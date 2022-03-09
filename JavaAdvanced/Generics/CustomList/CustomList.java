package CustomList;

import java.util.*;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> elements;

    public CustomList() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public T remove(int index) {
        if (ensureIndex(index)) {
            return this.elements.remove(index);
        }
        return null;
    }

    public boolean contains(T element) {
        for (T currentElement : this.elements) {
            if (currentElement.compareTo(element) == 0) {
                return true;
            }
        }
        return false;
    }

    public void swap(int firstIndex, int secondIndex) {
        if (ensureIndex(firstIndex) && ensureIndex(secondIndex)) {
            T firstElement = this.elements.get(firstIndex);
            T secondElement = this.elements.get(secondIndex);
            this.elements.set(firstIndex, secondElement);
            this.elements.set(secondIndex, firstElement);
        }
    }

    public int countGreaterThan(T element) {
        return (int) this.elements.stream()
                .filter(e -> e.compareTo(element) > 0)
                .count();
    }

    public T getMax() {
        return Collections.max(this.elements);
    }

    public T getMin() {
        return Collections.min(this.elements);
    }

    public int size() {
        return this.elements.size();
    }

    public T get(int index) {
        return this.elements.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.elements.size(); i++) {
            T currentElement = this.elements.get(i);
            if (i == this.elements.size() - 1) {
                sb.append(currentElement);
                break;
            }
            sb.append(currentElement).append(System.lineSeparator());
        }
        return sb.toString();
    }

    private boolean ensureIndex(int index) {
        return index >= 0 && index < this.elements.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < elements.size();
            }

            @Override
            public T next() {
                return elements.get(index++);
            }
        };
    }
}
