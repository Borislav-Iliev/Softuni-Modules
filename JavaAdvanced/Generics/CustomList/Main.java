package CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        CustomList<String> customList = new CustomList<String>();

        while (!command.equals("END")) {
            String[] tokens = command.split("\\s+");
            command = tokens[0];

            switch (command) {
                case "Add":
                    String addElement = tokens[1];
                    customList.add(addElement);
                    break;
                case "Remove":
                    int removeIndex = Integer.parseInt(tokens[1]);
                    customList.remove(removeIndex);
                    break;
                case "Contains":
                    String containsElement = tokens[1];
                    System.out.println(customList.contains(containsElement));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String compareElement = tokens[1];
                    System.out.println(customList.countGreaterThan(compareElement));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    System.out.println(customList);
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
