package FunctionalProgrammingExercises;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> people = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        LinkedHashMap<String, Predicate<String>> predicates = new LinkedHashMap<>();

        Predicate<String> predicate;

        while (!command.equals("Print")) {
            String[] tokens = command.split(";");
            command = tokens[0];
            String filterType = tokens[1];
            String filterParameter = tokens[2];

            if (command.equals("Add filter")) {
                predicate = getPredicate(filterType, filterParameter);
                predicates.put(filterParameter, predicate);
            } else if (command.equals("Remove filter")) {
                predicate = getPredicate(filterType, filterParameter);
                predicates.remove(filterParameter);
            }
            command = scanner.nextLine();
        }

        for (Predicate<String> currentPredicate : predicates.values()) {
            people.removeIf(currentPredicate);
        }

        System.out.println(String.join(" ", people));
    }

    public static Predicate<String> getPredicate(String filterType, String filterParameter) {
        switch (filterType) {
            case "StartsWith":
                return p -> p.startsWith(filterParameter);
            case "EndsWith":
                return p -> p.endsWith(filterParameter);
            case "Length":
                return p -> p.length() == Integer.parseInt(filterParameter);
        }
        return p -> p.contains(filterParameter);
    }
}
