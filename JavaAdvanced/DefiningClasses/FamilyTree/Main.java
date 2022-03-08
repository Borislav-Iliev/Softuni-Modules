package FamilyTree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String personId = scanner.nextLine();

        List<Person> people = new ArrayList<>();
        Map<String, List<String>> parentChildren = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!line.equals("End")) {

            if (line.contains(" - ")) {
                String[] tokens = line.split("\\s+-\\s+");
                String parent = tokens[0];
                String child = tokens[1];
                parentChildren.putIfAbsent(parent, new ArrayList<>());
                parentChildren.get(parent).add(child);
            } else {
                String[] tokens = line.split("\\s+");
                String name = tokens[0] + " " + tokens[1];
                String birthday = tokens[2];
                people.add(new Person(name, birthday));
            }

            line = scanner.nextLine();
        }

        parentChildren.forEach((parentId, children) -> {
            Person parent = findPerson(people, parentId);

            children.stream()
                    .map(childId -> findPerson(people, childId))
                    .forEach(parent::addChild);
        });

        Person forPerson = findPerson(people, personId);

        System.out.println(getFamilyTreeFor(forPerson));

    }

    private static Person findPerson(List<Person> people, String personId) {
        return people.stream()
                .filter(person -> person.getBirthday().equals(personId) || person.getName().equals(personId))
                .findFirst()
                .orElseThrow();
    }

    public static String getFamilyTreeFor(Person person) {
        return new StringBuilder()
                .append(person.toString()).append(System.lineSeparator())
                .append("Parents:").append(System.lineSeparator())
                .append(person.getParents().stream().map(Person::toString)
                        .collect(Collectors.joining(System.lineSeparator())))
                .append(person.getParents().isEmpty() ? "" : System.lineSeparator())
                .append("Children:").append(System.lineSeparator())
                .append(person.getChildren().stream().map(Person::toString)
                        .collect(Collectors.joining(System.lineSeparator())))
                .toString();
    }
}
