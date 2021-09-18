package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sequence = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        boolean isBalanced = true;
        for (int i = 0; i < sequence.length(); i++) {
            char currentBracket = sequence.charAt(i);

            if (currentBracket == '(' || currentBracket == '{' || currentBracket == '[') {
                stack.push(currentBracket);
            } else if (currentBracket == ')' || currentBracket == '}' || currentBracket == ']') {

                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }

                char openingBracket = stack.pop();

                if (openingBracket == '(' && currentBracket == ')') {
                    isBalanced = true;
                } else if (openingBracket == '{' && currentBracket == '}') {
                    isBalanced = true;
                } else if (openingBracket == '[' && currentBracket == ']') {
                    isBalanced = true;
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }

        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
