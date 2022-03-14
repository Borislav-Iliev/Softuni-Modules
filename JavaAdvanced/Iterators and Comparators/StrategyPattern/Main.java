package StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleCount = Integer.parseInt(scanner.nextLine());

        Set<Person> peopleSortedByName = new TreeSet<>(new NameComparator());
        Set<Person> peopleSortedByAge = new TreeSet<>(new AgeComparator());

        for (int i = 0; i < peopleCount; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            peopleSortedByName.add(person);
            peopleSortedByAge.add(person);
        }

        peopleSortedByName.forEach(System.out::println);
        peopleSortedByAge.forEach(System.out::println);
    }
}
