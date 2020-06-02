package VehicleExtension_02;

import com.sun.nio.sctp.IllegalReceiveException;

public abstract class Vehicle {
    private Double fuelQuantity;
    private Double fuelConsumptionPerKilometer;
    private Double tankCapacity;

    protected Vehicle(Double fuelQuantity, Double fuelConsumptionPerKilometer, Double tankCapacity) {
        this.tankCapacity = tankCapacity;
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

    public Double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(Double tankCapacity) {
        if(fuelQuantity <= 0) {
            throw new IllegalReceiveException("Fuel must be a positive number");
        }
        this.tankCapacity = tankCapacity;
    }

    public boolean drive(double distance, double summer_mode_on) {
        double neededFuel = distance * (this.fuelConsumptionPerKilometer + summer_mode_on);
        if(this.fuelQuantity < neededFuel) {
            return false;
        }

        this.fuelQuantity -= neededFuel;
        return true;
    }

    public boolean drive(double distance) {
        return drive(distance, 0);
    }

    public void refuel(double fuelQuantity) {
        if(fuelQuantity < 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if(fuelQuantity + this.fuelQuantity > this.tankCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += fuelQuantity;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
