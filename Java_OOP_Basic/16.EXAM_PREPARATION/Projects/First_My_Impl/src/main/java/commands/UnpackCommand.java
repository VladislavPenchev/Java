package commands;

import domain.Garage;
import domain.cars.Car;
import repositories.Repository;

public class UnpackCommand implements Command{

    private Repository<Car> carRepository;

    public UnpackCommand(Repository<Car> carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void execute(String[] args) {
        Car car = carRepository.findById(Integer.parseInt(args[1]));

        Garage garage = Garage.getInstance();

        garage.unParkCar(car);
    }
}
