package VehicleExtension_02;

public class Truck extends Vehicle {

    private static final double SUMMER_MODE_PERMANENT_ON = 1.6;

    public Truck(Double fuelQuantity, Double fuelConsumptionInLitersPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm, tankCapacity);
    }

    @Override
    public void refuel(double fuelQuantity) {
        double realFuelQuantity = fuelQuantity - ((fuelQuantity * 5) / 100);

        super.refuel(fuelQuantity);
    }
}
