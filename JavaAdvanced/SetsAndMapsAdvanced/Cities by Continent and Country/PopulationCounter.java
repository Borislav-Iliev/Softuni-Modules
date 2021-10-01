package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Map<String, Long>> populationData = new LinkedHashMap<>();

        while (!input.equals("report")) {
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            populationData.putIfAbsent(country, new LinkedHashMap<>());
            populationData.get(country).putIfAbsent(city, 0L);
            populationData.get(country).put(city, population);

            input = scanner.nextLine();
        }


        populationData.entrySet()
                .stream()
                .sorted((c1, c2) -> {
                    long firstPopulation = c1.getValue().values().stream().mapToLong(i -> i).sum();
                    long secondPopulation = c2.getValue().values().stream().mapToLong(i -> i).sum();

                    return Long.compare(secondPopulation, firstPopulation);
                }).forEach(c -> {
                    long sumPopulation = c.getValue().values().stream().mapToLong(i -> i).sum();
                    System.out.println(c.getKey() + " (total population: " + sumPopulation + ")");

                    c.getValue().entrySet()
                            .stream()
                            .sorted((s1, s2) -> Long.compare(s2.getValue(), s1.getValue()))
                            .forEach(s -> {
                                System.out.printf("=>%s: %d%n", s.getKey(), s.getValue());
                            });
                });
    }
}
