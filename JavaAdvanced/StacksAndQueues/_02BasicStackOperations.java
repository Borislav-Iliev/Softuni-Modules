package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class _02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] tokens = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int numberOfElementsToPush = tokens[0];
        int numberOfElementsToPop = tokens[1];
        int checkElement = tokens[2];

        int[] numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < numberOfElementsToPush; i++) {
            stack.push(numbers[i]);
        }

        for (int i = 0; i < numberOfElementsToPop; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            if (stack.contains(checkElement)) {
                System.out.println(true);
            } else {
                int smallest = Integer.MAX_VALUE;

                while (!stack.isEmpty()) {
                    int currentNumber = stack.pop();
                    if (currentNumber < smallest) {
                        smallest = currentNumber;
                    }
                }
                System.out.println(smallest);
            }
        }
    }
}
