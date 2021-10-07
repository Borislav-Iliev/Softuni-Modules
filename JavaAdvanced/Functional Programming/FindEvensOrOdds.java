package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] range = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String condition = scanner.nextLine();

        printNumbers(range[0], range[1],
                condition.equals("even")
                        ? n -> n % 2 == 0
                        : n -> n % 2 != 0);
    }

    public static void printNumbers(int begin, int end, Predicate<Integer> predicate) {
        System.out.println(IntStream
                .rangeClosed(begin, end)
                .boxed()
                .filter(predicate)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
