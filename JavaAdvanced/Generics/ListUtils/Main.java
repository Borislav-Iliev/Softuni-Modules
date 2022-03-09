package ListUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 13, 42, 69, 73);

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "a", "b", "c");

        System.out.println(ListUtils.getMax(numbers));
        System.out.println(ListUtils.getMin(strings));
    }
}
