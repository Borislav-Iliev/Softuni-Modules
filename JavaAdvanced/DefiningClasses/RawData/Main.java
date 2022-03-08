package RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];

            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);

            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];

            double firstTyrePressure = Double.parseDouble(tokens[5]);
            int firstTyreAge = Integer.parseInt(tokens[6]);
            double secondTyrePressure = Double.parseDouble(tokens[7]);
            int secondTyreAge = Integer.parseInt(tokens[8]);
            double thirdTyrePressure = Double.parseDouble(tokens[9]);
            int thirdTyreAge = Integer.parseInt(tokens[10]);
            double fourthTyrePressure = Double.parseDouble(tokens[11]);
            int fourthTyreAge = Integer.parseInt(tokens[12]);

            cars.add(new Car(model, new Engine(engineSpeed, enginePower),
                    new Cargo(cargoWeight, cargoType),
                    new Tires(firstTyrePressure, firstTyreAge,
                            secondTyrePressure, secondTyreAge,
                            thirdTyrePressure, thirdTyreAge,
                            fourthTyrePressure, fourthTyreAge)));
        }

        String cargoType = scanner.nextLine();

        if (cargoType.equals("fragile")) {
            printFragileCargo(cars);
        } else if (cargoType.equals("flamable")) {
            printFlamableCargo(cars);
        }
    }

    public static void printFragileCargo(List<Car> cars) {
        cars.stream()
                .filter(c -> c.getCargo().getType().equals("fragile") &&
                        c.getTires().getFirstTyrePressure() < 1 ||
                        c.getTires().getSecondTyrePressure() < 1 ||
                        c.getTires().getThirdTyrePressure() < 1 ||
                        c.getTires().getFourthTyrePressure() < 1)
                .forEach(c -> System.out.println(c.getModel()));
    }

    public static void printFlamableCargo(List<Car> cars) {
        cars.stream()
                .filter(c -> c.getCargo().getType().equals("flamable") && c.getEngine().getPower() > 250)
                .forEach(c -> System.out.println(c.getModel()));
    }
}
