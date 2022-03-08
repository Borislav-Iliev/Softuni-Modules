package CarSalesman;

public class Engine {
    private String model;
    private int power;
    private String engineDisplacement;
    private String efficiency;

    public Engine(String model, int power, String engineDisplacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.engineDisplacement = engineDisplacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power) {
        this(model, power, "n/a", "n/a");
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public String getEngineDisplacement() {
        return engineDisplacement;
    }

    public String getEfficiency() {
        return efficiency;
    }
}
