package _20February2021.dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private List<Car> data;
    private String name;
    private int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < capacity) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (int i = 0; i < this.data.size(); i++) {
            Car currentCar = this.data.get(i);
            if (currentCar.getManufacturer().equals(manufacturer) && currentCar.getModel().equals(model)) {
                this.data.remove(currentCar);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        return this.data.stream()
                .sorted((c1, c2) -> Integer.compare(c2.getYear(), c1.getYear()))
                .findFirst().orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return this.data.stream()
                .filter(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder("The cars are in a car _20February2021.dealership ");
        sb.append(this.name).append(":").append(System.lineSeparator());
        for (Car car : this.data) {
            sb.append(car.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
