package Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        Map<String, Person> people = new LinkedHashMap<>();

        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            String personName = tokens[0];
            String className = tokens[1];

            Person person;
            if (!people.containsKey(personName)) {
                person = new Person(personName);
            } else {
                person = people.get(personName);
            }

            switch (className) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    person.addCompany(companyName, department, salary);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    person.addPokemon(pokemonName, pokemonType);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    person.addParent(parentName, parentBirthday);
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    person.addChildren(childName, childBirthday);
                    break;
                case "car":
                    String carModel = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);
                    person.addCar(carModel, carSpeed);
                    break;
            }

            people.put(personName, person);
            command = scanner.nextLine();
        }

        String personName = scanner.nextLine();

        Person person = people.get(personName);

        System.out.println(person.toString());
    }
}
