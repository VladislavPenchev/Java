package domain;

import domain.cars.BaseCar;
import domain.cars.Car;

import java.util.ArrayList;
import java.util.List;

public final class Garage {
    private static Garage instance;
    private List<Car> parkedCars;

    private Garage() {
        this.parkedCars = new ArrayList<Car>();
    }

    public static Garage getInstance() {
        if(instance == null) {
            instance = new Garage();
        }

        return instance;
    }

    public void parkCar(Car car) {
        this.parkedCars.add(car);
    }

    public void unParkCar(Car car) {
        this.parkedCars.remove(car);
    }

    public List<Car> getParkedCars() {
        return parkedCars;
    }
}
