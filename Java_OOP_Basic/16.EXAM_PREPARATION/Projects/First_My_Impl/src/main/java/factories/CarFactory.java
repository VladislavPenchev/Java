package factories;

import domain.cars.BaseCar;
import domain.cars.ShowCarImpl;
import domain.cars.PerformanceCarImpl;

public final class CarFactory {

    private CarFactory() {

    }

    public static BaseCar createCar(int id, String carType, String brand, String model, int year, int horsepower,
                                    int acceleration, int suspension, int durability) {
        switch (carType) {
            case "PerformanceCar":
                return new ShowCarImpl(id, brand, model, year, horsepower, acceleration, suspension, durability);
            case "ShowCar":
                return new PerformanceCarImpl(id, brand, model, year, horsepower, acceleration, suspension, durability);
            default: return null;
        }
    }
}
