package Vehicles_01;

public abstract class Vehicle {
    private Double fuelQuantity;
    private Double fuelConsumptionPerKilometer;

    protected Vehicle(Double fuelQuantity, Double fuelConsumptionPerKilometer) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumptionPerKilometer(fuelConsumptionPerKilometer);
    }

    public Double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(Double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public Double getFuelConsumptionPerKilometer() {
        return fuelConsumptionPerKilometer;
    }

    protected void setFuelConsumptionPerKilometer(Double fuelConsumptionPerKilometer) {
        this.fuelConsumptionPerKilometer = fuelConsumptionPerKilometer;
    }

    public boolean drive(double distance) {
        double neededFuel = distance * this.fuelConsumptionPerKilometer;
        if(this.fuelQuantity < neededFuel) {
            return false;
        }

        this.fuelQuantity -= neededFuel;
        return true;
    }

    public void refuel(double fuelQuantity) {
        this.fuelQuantity += fuelQuantity;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
