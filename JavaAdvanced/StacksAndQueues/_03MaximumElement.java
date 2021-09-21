package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.Scanner;

public class _03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            switch (tokens[0]) {
                case "1":
                    int numberToBePushed = Integer.parseInt(tokens[1]);
                    stack.push(numberToBePushed);
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    //OptionalInt biggest = stack.stream().mapToInt(e -> Integer.parseInt(String.valueOf(e))).max();
                    //System.out.println(biggest.toString().replace("OptionalInt[", "").replace("]", ""));
                    int biggest = Collections.max(stack);
                    System.out.println(biggest);
                    break;
            }
        }
    }
}
