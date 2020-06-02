package VehicleExtension_02;

public class Bus extends Vehicle {
    private static final double SUMMER_MODE_PERMANENT_ON = 1.4;

    protected Bus(Double fuelQuantity, Double fuelConsumptionPerKilometer, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKilometer, tankCapacity);
    }
}
