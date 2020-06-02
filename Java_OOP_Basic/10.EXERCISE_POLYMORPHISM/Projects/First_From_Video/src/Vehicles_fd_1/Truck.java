package Vehicles_fd_1;

public class Truck extends Vehicle {

    private static final double SUMMER_MODE_PERMANENT_ON = 1.6;

    public Truck(double fuelQuantity, double fuelConsumptionPerKilometer) {
        super(fuelQuantity, fuelConsumptionPerKilometer);
    }

    @Override
    protected void setFuelConsumptionPerKilometer(double fuelConsumptionPerKilometer) {
        super.setFuelConsumptionPerKilometer(fuelConsumptionPerKilometer + this.SUMMER_MODE_PERMANENT_ON);
    }

    @Override
    public void refuel(double fuelQuantity) {

        double realFuelQuantity = fuelQuantity - ((fuelQuantity * 5) / 100);

        super.refuel(realFuelQuantity);
    }
}
