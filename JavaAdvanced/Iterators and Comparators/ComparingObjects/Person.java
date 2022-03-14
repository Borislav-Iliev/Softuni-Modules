package ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person other) {
        int sorted = this.name.compareTo(other.name);

        if (sorted == 0) {
            sorted = Integer.compare(this.age, other.age);

            if (sorted == 0) {
                sorted = this.town.compareTo(other.town);
            }
        }

        return sorted;
    }
}
