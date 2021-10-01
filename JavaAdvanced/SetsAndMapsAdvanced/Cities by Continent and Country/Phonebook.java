package SetsAndMapsAdvancedExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, String> phonebook = new HashMap<>();

        while (!input.equals("search")) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String phone = tokens[1];

            phonebook.put(name, phone);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("stop")) {
            String contact = input;

            String output = phonebook.containsKey(contact)
                    ? contact + " -> " + phonebook.get(contact)
                    : "Contact " + contact + " does not exist.";

            System.out.println(output);

            input = scanner.nextLine();
        }
    }
}
