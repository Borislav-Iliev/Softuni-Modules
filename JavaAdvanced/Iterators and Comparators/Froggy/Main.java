package Froggy;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        int[] numbers = Arrays
                .stream(command.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Lake lake = new Lake(numbers);

        List<Integer> outputNumbers = new ArrayList<>();

        for (Integer number : lake) {
            outputNumbers.add(number);
        }

        String output = outputNumbers
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(output);
    }
}
