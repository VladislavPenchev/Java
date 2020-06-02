package VehicleExtension_02;

public class Car extends Vehicle {

    private static final double SUMMER_MODE_PERMANENT_ON = 0.9;

    public Car(Double fuelQuantity, Double fuelConsumptionInLitersPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm, tankCapacity);
    }
}
