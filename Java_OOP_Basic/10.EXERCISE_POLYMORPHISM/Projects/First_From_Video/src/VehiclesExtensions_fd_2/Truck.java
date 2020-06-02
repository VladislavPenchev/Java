package VehiclesExtensions_fd_2;

public class Truck extends Vehicle {

    private static final double SUMMER_MODE_PERMANENT_ON = 1.6;

    public Truck(double fuelQuantity, double fuelConsumptionPerKilometer, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKilometer, tankCapacity);
    }

    @Override
    public void refuel(double fuelQuantity) {

        double realFuelQuantity = fuelQuantity - ((fuelQuantity * 5) / 100);

        super.refuel(realFuelQuantity);
    }
}
