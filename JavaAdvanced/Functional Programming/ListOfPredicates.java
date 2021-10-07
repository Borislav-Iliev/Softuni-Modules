package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class _09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int range = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        BiFunction<List<Integer>, Integer, Boolean> isDivisible = ((list, number) -> {
            for (int numberInList : list) {
                if (number % numberInList != 0) {
                    return false;
                }
            }
            return true;
        });

        for (int currentNumber = 1; currentNumber <= range; currentNumber++) {
            if (isDivisible.apply(numbers, currentNumber)) {
                System.out.print(currentNumber + " ");
            }

        }
    }
}
