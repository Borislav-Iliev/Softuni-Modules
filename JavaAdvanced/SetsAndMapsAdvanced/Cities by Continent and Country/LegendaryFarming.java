package SetsAndMapsAdvancedExercises;

import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> keyMaterials = new TreeMap<>();
        Map<String, Integer> junkMaterials = new TreeMap<>();

        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        boolean isObtained = false;

        while (!isObtained) {
            String[] tokens = scanner.nextLine().split("\\s+");

            for (int i = 0; i < tokens.length - 1; i += 2) {
                int quantity = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1].toLowerCase(Locale.ROOT);

                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    keyMaterials.putIfAbsent(material, 0);
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);

                    if (keyMaterials.get(material) >= 250) {
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        if (material.equals("shards")) {
                            System.out.println("Shadowmourne obtained!");
                        } else if (material.equals("fragments")) {
                            System.out.println("Valanyr obtained!");
                        } else {
                            System.out.println("Dragonwrath obtained!");
                        }
                        isObtained = true;
                        break;
                    }
                } else {
                    junkMaterials.putIfAbsent(material, 0);
                    junkMaterials.put(material, junkMaterials.get(material) + quantity);
                }
            }
        }
        keyMaterials.entrySet()
                .stream()
                .sorted((m1, m2) -> Integer.compare(m2.getValue(), m1.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        junkMaterials.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
