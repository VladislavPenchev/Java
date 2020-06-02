package Vehicles_01;

public class Truck extends Vehicle{

    private static final double SUMMER_MODE_PERMANENT_ON = 1.6;

    public Truck(Double fuelQuantity, Double fuelConsumptionInLitersPerKm) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm);
    }

    @Override
    protected void setFuelConsumptionPerKilometer(Double fuelConsumptionPerKilometer) {
        super.setFuelConsumptionPerKilometer(fuelConsumptionPerKilometer + SUMMER_MODE_PERMANENT_ON);
    }

    @Override
    public void refuel(double fuelQuantity) {
        double realFuelQuantity = fuelQuantity - ((fuelQuantity * 5) / 100);

        super.refuel(fuelQuantity);
    }
}
