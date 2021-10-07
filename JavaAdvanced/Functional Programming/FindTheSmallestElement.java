package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class _07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Consumer<List<Integer>> findAndPrintTheSmallestNumberIndex = list -> {
            int min = Integer.MAX_VALUE;
            for (Integer number : list) {
                if (number <= min) {
                    min = number;
                }
            }
            System.out.println(list.lastIndexOf(min));
        };
        findAndPrintTheSmallestNumberIndex.accept(numbers);
    }
}
