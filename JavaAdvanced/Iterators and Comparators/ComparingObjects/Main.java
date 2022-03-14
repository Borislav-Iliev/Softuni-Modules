package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Person> people = new ArrayList<>();

        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];

            Person person = new Person(name, age, town);
            people.add(person);

            input = scanner.nextLine();
        }

        int compareIndex = Integer.parseInt(scanner.nextLine());
        Person comparePerson = people.get(compareIndex - 1);

        int equalCounter = 0;
        int notEqualCounter = 0;

        for (Person currentPerson : people) {

            if (currentPerson.compareTo(comparePerson) == 0) {
                equalCounter++;
            } else {
                notEqualCounter++;
            }
        }

        String output = equalCounter <= 1
                ? "No matches"
                : equalCounter + " " + notEqualCounter + " " + people.size();

        System.out.println(output);
    }
}
