package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputTokens = scanner.nextLine().split("\\s+");
        int numberOfElementsToOffer = Integer.parseInt(inputTokens[0]);
        int numberOfElementsToPoll = Integer.parseInt(inputTokens[1]);
        int checkElement = Integer.parseInt(inputTokens[2]);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numberOfElementsToOffer; i++) {
            queue.offer(numbers[i]);
        }

        for (int i = 0; i < numberOfElementsToPoll; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println(0);
            return;
        }

        int minValue = Integer.MAX_VALUE;
        if (queue.contains(checkElement)) {
            System.out.println(true);
        } else {
            while (!queue.isEmpty()) {
                int currentNumber = queue.poll();

                if (currentNumber < minValue) {
                    minValue = currentNumber;
                }
            }
            System.out.println(minValue);
        }
    }
}
