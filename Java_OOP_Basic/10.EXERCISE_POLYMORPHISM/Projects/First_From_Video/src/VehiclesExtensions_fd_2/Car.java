package VehiclesExtensions_fd_2;

public class Car extends Vehicle {

    private static final double SUMMER_MODE_PERMANENT_ON = 0.9;

    public Car(double fuelQuantity, double fuelConsumptionPerKilometer, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKilometer, tankCapacity);
    }

}