package OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            people.add(person);
        }

        Predicate<Person> predicate = p -> p.getAge() > 30;
        people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .filter(predicate)
                .forEach(p -> System.out.printf("%s - %d%n", p.getName(), p.getAge()));
    }
}
