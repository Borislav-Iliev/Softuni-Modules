package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> people = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        Predicate<String> predicate;

        while (!command.equals("Party!")) {
            String[] tokens = command.split("\\s+");
            command = tokens[0];
            String condition = tokens[1];
            String parameter = tokens[2];

            if (command.equals("Remove")) {
                predicate = getPredicate(condition, parameter);
                people.removeIf(predicate);
            } else if (command.equals("Double")) {
                predicate = getPredicate(condition, parameter);
                for (int i = 0; i < people.size(); i++) {
                    String currentPerson = people.get(i);
                    if (predicate.test(currentPerson)) {
                        people.add(people.lastIndexOf(currentPerson) + 1, currentPerson);
                        i++;
                    }
                }
            }
            command = scanner.nextLine();
        }
        Collections.sort(people);
        String output = people.isEmpty()
                ? "Nobody is going to the party!"
                : String.join(", ", people) + " are going to the party!";

        System.out.println(output);
    }

    public static Predicate<String> getPredicate(String condition, String parameter) {
        switch (condition) {
            case "StartsWith":
                return p -> p.startsWith(parameter);
            case "EndsWith":
                return p -> p.endsWith(parameter);
        }
        return p -> p.length() == Integer.parseInt(parameter);
    }
}
