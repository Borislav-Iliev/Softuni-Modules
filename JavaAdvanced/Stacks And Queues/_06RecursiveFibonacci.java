package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _06RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        if (n == 0 || n == 1) {
            System.out.println(1);
        } else if (n >= 2) {
            ArrayDeque<Long> queue = new ArrayDeque<>();
            queue.offer(1L);
            queue.offer(1L);
            for (int i = 0; i < n; i++) {
                long firstNumber = queue.poll();
                long secondNumber = queue.peek();
                long result = firstNumber + secondNumber;
                queue.offer(result);
            }
            System.out.println(queue.peek());
        }
    }
}

