package CatLady;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Cat> cats = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String breed = tokens[0];
            String name = tokens[1];
            double attribute = Double.parseDouble(tokens[2]);

            cats.putIfAbsent(name, new Cat(breed, name, attribute));

            input = scanner.nextLine();
        }

        String name = scanner.nextLine();

        if (cats.containsKey(name)) {
            String output = String.format("%s %s %.2f", cats.get(name).getBreed(), cats.get(name).getName(), cats.get(name).getAttribute());
            System.out.println(output);
        }
    }
}
