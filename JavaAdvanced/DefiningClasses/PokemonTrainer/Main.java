package PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        while (!command.equals("Tournament")) {
            String[] tokens = command.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Trainer trainer = new Trainer(trainerName, 0, new ArrayList<>());
            trainers.putIfAbsent(trainerName, trainer);
            trainers.get(trainerName).getPokemons().add(new Pokemon(pokemonName, pokemonElement, pokemonHealth));

            command = scanner.nextLine();
        }

        String element = scanner.nextLine();

        while (!element.equals("End")) {
            boolean isFound = false;
            for (Trainer trainer : trainers.values()) {
                for (Pokemon pokemon : trainer.getPokemons()) {
                    if (pokemon.getElement().equals(element)) {
                        trainer.setNumberOfBadges(trainer.getNumberOfBadges() + 1);
                        isFound = true;
                        break;
                    }
                }
                if (!isFound) {
                    for (Pokemon pokemon : trainer.getPokemons()) {
                        pokemon.setHealth(pokemon.getHealth() - 10);
                        if (pokemon.getHealth() <= 0) {
                            trainer.removePokemon();
                            if (trainer.getPokemons().size() == 0){
                                break;
                            }
                        }
                    }
                }
            }

            element = scanner.nextLine();
        }

        trainers.entrySet()
                .stream()
                .sorted((t1, t2) -> Integer.compare(t2.getValue().getNumberOfBadges(), t1.getValue().getNumberOfBadges()))
                .forEach(t -> System.out.printf("%s %d %d%n", t.getKey(), t.getValue().getNumberOfBadges(), t.getValue().getPokemons().size()));
    }
}
