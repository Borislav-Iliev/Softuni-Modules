package _20February2021;

import java.util.*;

public class _01MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstMagicBoxArray = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondMagicBoxArray = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> firstMagicBox = new ArrayDeque<>();

        for (int element : firstMagicBoxArray) {
            firstMagicBox.offer(element);
        }

        ArrayDeque<Integer> secondMagicBox = new ArrayDeque<>();

        for (int element : secondMagicBoxArray) {
            secondMagicBox.push(element);
        }

        List<Integer> claimedItems = new ArrayList<>();

        while (firstMagicBox.size() != 0 && secondMagicBox.size() != 0) {
            int currentFirstBoxValue = firstMagicBox.poll();
            int currentSecondBoxValue = secondMagicBox.pop();

            int sum = currentFirstBoxValue + currentSecondBoxValue;

            if (sum % 2 == 0) {
                claimedItems.add(sum);
            } else {
                firstMagicBox.addFirst(currentFirstBoxValue);
                firstMagicBox.offer(currentSecondBoxValue);
            }
        }

        String firstOutput = firstMagicBox.isEmpty()
                ? "First magic box is empty." :
                "Second magic box is empty.";

        System.out.println(firstOutput);

        int sum = claimedItems.stream().mapToInt(i -> i).sum();

        String secondOutput = sum > 90
                ? "Wow, your prey was epic! Value: " + sum
                : "Poor prey... Value: " + sum;

        System.out.println(secondOutput);
    }
}
