package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputTokens = scanner.nextLine().split("\\s+");
        int numberOfElementsToPush = Integer.parseInt(inputTokens[0]);
        int numberOfElementsToPop = Integer.parseInt(inputTokens[1]);
        int checkElement = Integer.parseInt(inputTokens[2]);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numberOfElementsToPush; i++) {
            stack.push(numbers[i]);
        }

        for (int i = 0; i < numberOfElementsToPop; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
            return;
        }

        int minValue = Integer.MAX_VALUE;
        if (stack.contains(checkElement)) {
            System.out.println(true);
        } else {
            while (!stack.isEmpty()) {
                int currentNumber = stack.pop();

                if (currentNumber < minValue) {
                    minValue = currentNumber;
                }
            }
            System.out.println(minValue);
        }
    }
}
