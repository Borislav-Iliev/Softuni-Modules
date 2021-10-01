package SetsAndMapsAdvanced;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, ArrayList<String>>> continentsInfo = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            continentsInfo.putIfAbsent(continent, new LinkedHashMap<>());
            continentsInfo.get(continent).putIfAbsent(country, new ArrayList<>());
            continentsInfo.get(continent).get(country).add(city);
        }

        continentsInfo.entrySet()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ":");
                    entry.getValue().entrySet().forEach(element -> {
                        System.out.printf("  %s -> ", element.getKey());
                        System.out.print(String.join(", ", element.getValue()));
                        System.out.println();
                    });
                });
    }
}
