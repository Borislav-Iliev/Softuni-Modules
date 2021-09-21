package StacksAndQueuesExercise;

import java.util.Scanner;
import java.util.Stack;


public class _08InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine().replace(" ", "");

        System.out.println(GFG.infixToRpn(expression));
    }

    static class GFG {

        private static boolean letterOrDigit(char c) {

            if (Character.isLetterOrDigit(c))
                return true;
            else
                return false;
        }

        static int getPrecedence(char ch) {

            if (ch == '+' || ch == '-')
                return 1;
            else if (ch == '*' || ch == '/')
                return 2;
            else if (ch == '^')
                return 3;
            else
                return -1;
        }


        static String infixToRpn(String expression) {

            Stack<Character> stack = new Stack<>();

            StringBuilder output = new StringBuilder(new String(""));

            for (int i = 0; i < expression.length(); ++i) {
                char c = expression.charAt(i);

                if (letterOrDigit(c))
                    output.append(c).append(" ");

                else if (c == '(')
                    stack.push(c);

                else if (c == ')') {
                    while (!stack.isEmpty()
                            && stack.peek() != '(')
                        output.append(stack.pop()).append(" ");

                    stack.pop();
                } else {
                    while (
                            !stack.isEmpty()
                                    && getPrecedence(c)
                                    <= getPrecedence(stack.peek())) {

                        output.append(stack.pop()).append(" ");
                    }
                    stack.push(c);
                }
            }
            while (!stack.isEmpty()) {
                if (stack.peek() == '(')
                    return "This expression is invalid";
                output.append(stack.pop()).append(" ");
            }
            return output.toString();
        }
    }
}
