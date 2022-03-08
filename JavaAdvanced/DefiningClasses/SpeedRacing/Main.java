package SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int fuelAmount = Integer.parseInt(tokens[1]);
            double fuelCostFor1Kilometer = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuelAmount, fuelCostFor1Kilometer, 0);
            cars.put(model, car);
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            String carModel = tokens[1];
            int distanceTravelled = Integer.parseInt(tokens[2]);

            cars.get(carModel).drive(distanceTravelled);

            command = scanner.nextLine();
        }

        for (Map.Entry<String, Car> entry : cars.entrySet()) {
            System.out.printf("%s %.2f %d%n", entry.getKey(), entry.getValue().getFuelAmount(), entry.getValue().getDistanceTravelled());
        }
    }
}
