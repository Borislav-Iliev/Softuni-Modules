package CatLady;

public class Cat {
    private String breed;
    private String name;
    private double attribute;

    public Cat(String breed, String name, double attribute) {
        this.breed = breed;
        this.name = name;
        this.attribute = attribute;
    }

    public String getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }

    public double getAttribute() {
        return attribute;
    }

}
