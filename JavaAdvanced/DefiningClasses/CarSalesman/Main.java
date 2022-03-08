package CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfEngines = Integer.parseInt(scanner.nextLine());

        Map<String, Engine> engines = new LinkedHashMap<>();

        for (int i = 0; i < numberOfEngines; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String engineModel = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            if (tokens.length == 2) {
                engines.put(engineModel, new Engine(engineModel, power));

            } else if (tokens.length == 3) {

                if (Character.isDigit(tokens[2].charAt(0))) {
                    String engineDisplacement = tokens[2];
                    engines.put(engineModel, new Engine(engineModel, power, engineDisplacement, "n/a"));
                } else {
                    String efficiency = tokens[2];
                    engines.put(engineModel, new Engine(engineModel, power, "n/a", efficiency));
                }

            } else if (tokens.length == 4) {
                String engineDisplacement = tokens[2];
                String efficiency = tokens[3];
                engines.put(engineModel, new Engine(engineModel, power, engineDisplacement, efficiency));
            }
        }

        List<Car> cars = new ArrayList<>();

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCars; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String carModel = tokens[0];
            String engineType = tokens[1];

            if (!engines.containsKey(engineType)) {
                continue;
            }

            Engine currentEngine = engines.get(engineType);

            if (tokens.length == 2) {
                cars.add(new Car(carModel, currentEngine));

            } else if (tokens.length == 3) {

                if (Character.isDigit(tokens[2].charAt(0))) {
                    String weight = tokens[2];
                    cars.add(new Car(carModel, currentEngine, weight, "n/a"));
                } else {
                    String color = tokens[2];
                    cars.add(new Car(carModel, currentEngine, "n/a", color));
                }

            } else if (tokens.length == 4) {
                String weight = tokens[2];
                String color = tokens[3];
                cars.add(new Car(carModel, currentEngine, weight, color));
            }
        }

        cars.forEach(c -> System.out.println(c.toString()));
    }
}
