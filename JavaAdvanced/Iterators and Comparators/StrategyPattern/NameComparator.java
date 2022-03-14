package StrategyPattern;

import java.util.Comparator;
import java.util.Locale;

public class NameComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        int sorted = Integer.compare(p1.getName().length(), p2.getName().length());

        if (sorted == 0) {
            char firstPersonStartingLetter = p1.getName().toLowerCase(Locale.ROOT).charAt(0);
            char secondPersonStartingLetter = p2.getName().toLowerCase(Locale.ROOT).charAt(0);
            sorted = Character.compare(firstPersonStartingLetter, secondPersonStartingLetter);
        }

        return sorted;
    }
}
