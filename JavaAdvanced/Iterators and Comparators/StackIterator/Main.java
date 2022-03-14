package StackIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        Stack stack = new Stack();

        while (!command.equals("END")) {
            String[] tokens = command.split("\\s+");
            String commandType = tokens[0];

            switch (commandType) {
                case "Push":
                    int[] numbers = new int[tokens.length - 1];
                    for (int i = 1; i < tokens.length; i++) {
                        int current = Integer.parseInt(tokens[i].replace(",", ""));
                        numbers[i - 1] = current;
                    }

                    for (int number : numbers) {
                        stack.push(number);
                    }
                    break;
                case "Pop":
                    if (stack.pop() == -1) {
                        System.out.println("No elements");
                        return;
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        stack.forEach(System.out::println);
        stack.forEach(System.out::println);
    }
}
