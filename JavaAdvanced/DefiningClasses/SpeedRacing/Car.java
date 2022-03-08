package SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostFor1Kilometer;
    private int distanceTravelled;

    public Car(String model, int fuelAmount, double fuelCostFor1Kilometer, int distanceTravelled) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1Kilometer = fuelCostFor1Kilometer;
        this.distanceTravelled = distanceTravelled;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(int fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCostFor1Kilometer() {
        return fuelCostFor1Kilometer;
    }

    public void setFuelCostFor1Kilometer(double fuelCostFor1Kilometer) {
        this.fuelCostFor1Kilometer = fuelCostFor1Kilometer;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public void drive(int distanceTravelled) {
        double fuelCostForDistanceTravelled = distanceTravelled * fuelCostFor1Kilometer;

        if (fuelCostForDistanceTravelled > fuelAmount) {
            System.out.println("Insufficient fuel for the drive");
        } else {
            fuelAmount -= fuelCostForDistanceTravelled;
            this.distanceTravelled += distanceTravelled;
        }
    }
}
