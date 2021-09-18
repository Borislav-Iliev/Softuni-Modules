package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);

            if (symbol == '(') {
                stack.push(i);
            } else if (symbol == ')') {
                int startIndex = stack.pop();
                String subExpression = expression.substring(startIndex, i + 1);
                System.out.println(subExpression);
            }
        }
    }
}
