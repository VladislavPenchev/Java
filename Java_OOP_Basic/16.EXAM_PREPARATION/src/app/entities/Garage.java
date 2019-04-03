package app.entities;

import app.contracts.Car;

import java.util.ArrayList;
import java.util.Collection;

public class Garage {
    private Collection<Car> parkedCars;

    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    public boolean hasCar (Car car){
        return this.parkedCars.contains(car);
    }

    public void addInGarage(Car car){
        this.parkedCars.add(car);
    }

    public void removeFromGarage(Car car) {
        this.parkedCars.remove(car);
    }
}
