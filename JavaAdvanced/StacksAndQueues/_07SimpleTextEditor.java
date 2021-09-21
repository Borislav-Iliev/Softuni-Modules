package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder text = new StringBuilder("");

        ArrayDeque<String> stack = new ArrayDeque<>();

        String currentText = "";
        stack.push(currentText);

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            switch (tokens[0]) {
                case "1":
                    String appendString = tokens[1];
                    text.append(appendString);
                    currentText = text.toString();
                    stack.push(currentText);
                    break;
                case "2":
                    int eraseCount = Integer.parseInt(tokens[1]);
                    text.reverse();
                    text.delete(0, eraseCount);
                    text.reverse();
                    currentText = text.toString();
                    stack.push(currentText);
                    break;
                case "3":
                    int index = Integer.parseInt(tokens[1]);
                    char symbol = text.charAt(index - 1);
                    System.out.println(symbol);
                    break;
                case "4":
                    stack.pop();
                    String lastState = stack.peek();
                    assert lastState != null;
                    currentText = lastState;
                    text = new StringBuilder(lastState);
                    break;
            }
        }
    }
}
