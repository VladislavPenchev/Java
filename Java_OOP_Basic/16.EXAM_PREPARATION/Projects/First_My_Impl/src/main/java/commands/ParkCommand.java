package commands;

import domain.Garage;
import domain.cars.Car;
import repositories.Repository;

public class ParkCommand implements Command{

    private Repository<Car> carRepository;

    public ParkCommand(Repository<Car> carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void execute(String[] args) {
        Garage garage = Garage.getInstance();

        Car car = carRepository.findById(Integer.parseInt(args[1]));

        garage.parkCar(car);

    }
}
