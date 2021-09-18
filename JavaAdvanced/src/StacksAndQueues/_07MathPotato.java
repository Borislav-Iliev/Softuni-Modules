package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String child : children) {
            queue.offer(child);
        }

        int cycleNumber = 1;
        while (queue.size() > 1) {

            if (checkForPrime(cycleNumber)) {
                printChildName(n, queue);
            } else {
                removedChildFromCircle(n, queue);
            }
            cycleNumber++;
        }

        System.out.println("Last is " + queue.peek());
    }

    private static void printChildName(int n, ArrayDeque<String> queue) {
        for (int i = 1; i < n; i++) {
            String removed = queue.poll();
            queue.offer(removed);
        }
        System.out.println("Prime " + queue.peek());

    }

    private static void removedChildFromCircle(int n, ArrayDeque<String> queue) {
        for (int i = 1; i < n; i++) {
            String removed = queue.poll();
            queue.offer(removed);
        }
        System.out.println("Removed " + queue.peek());
        queue.poll();
    }

    private static boolean checkForPrime(int inputNumber) {
        boolean isItPrime = true;

        if (inputNumber <= 1) {
            isItPrime = false;

            return isItPrime;
        } else {
            for (int i = 2; i <= inputNumber / 2; i++) {
                if ((inputNumber % i) == 0) {
                    isItPrime = false;
                    break;
                }
            }

            return isItPrime;
        }
    }
}
