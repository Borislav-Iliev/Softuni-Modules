package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfDragons = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, Dragon>> dragons = new LinkedHashMap<>();

        for (int i = 0; i < numberOfDragons; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            int damage = tokens[2].equals("null") ? 45 : Integer.parseInt(tokens[2]);
            int health = tokens[3].equals("null") ? 250 : Integer.parseInt(tokens[3]);
            int armour = tokens[4].equals("null") ? 10 : Integer.parseInt(tokens[4]);

            if (!dragons.containsKey(type)) {
                dragons.put(type, new TreeMap<>());
                dragons.get(type).put(name, new Dragon(damage, health, armour));
            } else {
                Map<String, Dragon> currentDragon = dragons.get(type);
                if (!currentDragon.containsKey(name)) {
                    currentDragon.put(name, new Dragon(damage, health, armour));
                    continue;
                }
                currentDragon.get(name).setDamage(damage);
                currentDragon.get(name).setHealth(health);
                currentDragon.get(name).setArmour(armour);
            }
        }

        for (Map.Entry<String, Map<String, Dragon>> entry : dragons.entrySet()) {
            int size = entry.getValue().size();
            double[] average = calculateAverageAttributes(entry.getValue(), size);
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", entry.getKey(), average[0], average[1], average[2]);
            for (Map.Entry<String, Dragon> dragonEntry : entry.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", dragonEntry.getKey(), dragonEntry.getValue().getDamage(),
                        dragonEntry.getValue().getHealth(), dragonEntry.getValue().getArmour());
            }
        }
    }

    public static double[] calculateAverageAttributes(Map<String, Dragon> value, int size) {
        int totalDamage = 0;
        int totalHealth = 0;
        int totalArmour = 0;

        for (Map.Entry<String, Dragon> entry : value.entrySet()) {
            totalDamage += entry.getValue().getDamage();
            totalHealth += entry.getValue().getHealth();
            totalArmour += entry.getValue().getArmour();
        }

        return new double[]{1.00 * totalDamage / size,
                1.00 * totalHealth / size,
                1.00 * totalArmour / size};
    }

    static class Dragon {
        private int damage;
        private int health;
        private int armour;

        public Dragon(int damage, int health, int armour) {
            this.damage = damage;
            this.health = health;
            this.armour = armour;
        }

        public int getDamage() {
            return damage;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public int getArmour() {
            return armour;
        }

        public void setArmour(int armour) {
            this.armour = armour;
        }
    }
}
