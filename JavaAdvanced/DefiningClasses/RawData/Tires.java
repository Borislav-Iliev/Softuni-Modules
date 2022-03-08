package RawData;

public class Tires {
    private double firstTyrePressure;
    private int firstTyreAge;

    private double secondTyrePressure;
    private int secondTyreAge;

    private double thirdTyrePressure;
    private int thirdTyreAge;

    private double fourthTyrePressure;
    private int fourthTyreAge;

    public Tires(double firstTyrePressure, int firstTyreAge,
                 double secondTyrePressure, int secondTyreAge,
                 double thirdTyrePressure, int thirdTyreAge,
                 double fourthTyrePressure, int fourthTyreAge) {
        this.firstTyrePressure = firstTyrePressure;
        this.firstTyreAge = firstTyreAge;
        this.secondTyrePressure = secondTyrePressure;
        this.secondTyreAge = secondTyreAge;
        this.thirdTyrePressure = thirdTyrePressure;
        this.thirdTyreAge = thirdTyreAge;
        this.fourthTyrePressure = fourthTyrePressure;
        this.fourthTyreAge = fourthTyreAge;
    }

    public double getFirstTyrePressure() {
        return firstTyrePressure;
    }

    public double getSecondTyrePressure() {
        return secondTyrePressure;
    }

    public double getThirdTyrePressure() {
        return thirdTyrePressure;
    }

    public double getFourthTyrePressure() {
        return fourthTyrePressure;
    }
}
