package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] expression = scanner.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = expression.length - 1; i >= 0; i--) {
            stack.push(expression[i]);
        }

        while (stack.size() > 1) {
            int firstNumber = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondNumber = Integer.parseInt(stack.pop());

            int result = 0;

            if (operator.equals("+")) {
                result = firstNumber + secondNumber;
            } else if (operator.equals("-")) {
                result = firstNumber - secondNumber;
            }

            stack.push(String.valueOf(result));
        }

        System.out.println(stack.peek());
    }
}
