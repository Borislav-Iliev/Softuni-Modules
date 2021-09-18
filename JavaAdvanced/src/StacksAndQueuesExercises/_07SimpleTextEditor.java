package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder("");

        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push(text.toString());
        String currentStateOfText = "";

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");

            switch (command[0]) {
                case "1":
                    String string = command[1];
                    text.append(string);
                    currentStateOfText = text.toString();
                    stack.push(currentStateOfText);
                    break;
                case "2":
                    int count = Integer.parseInt(command[1]);
                    text.reverse();
                    text.replace(0, count, "");
                    text.reverse();
                    currentStateOfText = text.toString();
                    stack.push(currentStateOfText);
                    break;
                case "3":
                    int index = Integer.parseInt(command[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    stack.pop();
                    currentStateOfText = stack.peek();
                    text = new StringBuilder(currentStateOfText);
                    break;
            }
        }
    }
}
