package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] tokens = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int numberOfElementsToOffer = tokens[0];
        int numberOfElementsToPoll = tokens[1];
        int checkElement = tokens[2];

        int[] numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < numberOfElementsToOffer; i++) {
            queue.offer(numbers[i]);
        }

        for (int i = 0; i < numberOfElementsToPoll; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            if (queue.contains(checkElement)) {
                System.out.println(true);
            } else {
                int smallest = Integer.MAX_VALUE;
                while (!queue.isEmpty()) {
                    int currentNumber = queue.poll();
                    if (currentNumber < smallest) {
                        smallest = currentNumber;
                    }
                }
                System.out.println(smallest);
            }
        }
    }
}
