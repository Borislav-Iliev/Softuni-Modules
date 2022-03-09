package GenericSwapMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> data;

    public void add(T value) {
        if (this.data == null) {
            this.data = new ArrayList<>();
        }
        this.data.add(value);
    }

    public void swap(int firstIndex, int secondIndex) {
        T firstElement = this.data.get(firstIndex);
        T secondElement = this.data.get(secondIndex);

        this.data.set(firstIndex, secondElement);
        this.data.set(secondIndex, firstElement);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : this.data) {
            sb.append(element.getClass().getName()).append(": ").append(element).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
