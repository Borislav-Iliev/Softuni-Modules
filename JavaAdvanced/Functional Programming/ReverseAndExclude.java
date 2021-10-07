package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int excludeNumber = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numbers);

        Predicate<Integer> removeDivisibleNumbers = n -> n % excludeNumber != 0;
        Consumer<Integer> printNumbers = n -> System.out.print(n + " ");

        numbers.stream().filter(removeDivisibleNumbers).forEach(printNumbers);
    }
}
