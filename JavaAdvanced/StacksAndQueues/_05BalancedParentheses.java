package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        boolean isBalanced = false;

        for (int i = 0; i < input.length(); i++) {
            char currentBracket = input.charAt(i);

            if (currentBracket == '(' || currentBracket == '{' || currentBracket == '[') {
                stack.push(currentBracket);
            } else if (currentBracket == ')' || currentBracket == '}' || currentBracket == ']') {

                if (stack.isEmpty()){
                    isBalanced = false;
                    break;
                }

                char lastOpenBracket = stack.pop();


                if (lastOpenBracket == '(' && currentBracket == ')') {
                    isBalanced = true;
                } else if (lastOpenBracket == '{' && currentBracket == '}') {
                    isBalanced = true;
                } else if (lastOpenBracket == '[' && currentBracket == ']') {
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
