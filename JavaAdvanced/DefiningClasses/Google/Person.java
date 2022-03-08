package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Pokemon> pokemon;
    private List<Parents> parents;
    private List<Children> children;

    public Person(String name) {
        this.name = name;
    }

    public void addCompany(String companyName, String department, double salary) {
        this.company = new Company(companyName, department, salary);
    }

    public void addPokemon(String pokemonName, String pokemonType) {
        try {
            this.pokemon.add(new Pokemon(pokemonName, pokemonType));
        } catch (NullPointerException e) {
            this.pokemon = new ArrayList<>();
            this.pokemon.add(new Pokemon(pokemonName, pokemonType));
        }
    }

    public void addParent(String parentName, String parentBirthday) {
        try {
            this.parents.add(new Parents(parentName, parentBirthday));
        } catch (NullPointerException e) {
            this.parents = new ArrayList<>();
            this.parents.add(new Parents(parentName, parentBirthday));
        }
    }

    public void addChildren(String childName, String childBirthday) {
        try {
            this.children.add(new Children(childName, childBirthday));
        } catch (NullPointerException e) {
            this.children = new ArrayList<>();
            this.children.add(new Children(childName, childBirthday));
        }
    }

    public void addCar(String carModel, int carSpeed) {
        this.car = new Car(carModel, carSpeed);
    }

    @Override
    public String toString() {
        String companyOutput = this.company == null ? "" : this.company.toString();
        String carOutput = this.car == null ? "" : this.car.toString();

        StringBuilder pokemonOutput = new StringBuilder("");
        if (this.pokemon != null) {
            for (Pokemon pokemon : this.pokemon) {
                pokemonOutput.append(pokemon.toString());
            }
        }

        StringBuilder parentsOutput = new StringBuilder("");
        if (this.parents != null) {
            for (Parents parent : this.parents) {
                parentsOutput.append(parent.toString());
            }
        }

        StringBuilder childrenOutput = new StringBuilder("");
        if (this.children != null) {
            for (Children child : this.children) {
                childrenOutput.append(child.toString());
            }
        }

        return String.format("%s%n" +
                "Company:%n%s" +
                "Car:%n%s" +
                "Pokemon:%n%s" +
                "Parents:%n%s" +
                "Children:%n%s", this.name, companyOutput, carOutput, pokemonOutput, parentsOutput, childrenOutput);
    }
}
