package commands;

import domain.cars.BaseCar;
import domain.cars.Car;
import factories.CarFactory;
import repositories.Repository;

public class RegisterCommand implements Command {

    private Repository<Car> repository;

    public RegisterCommand(Repository<Car> repository) {
        this.repository = repository;
    }

    @Override
    public void execute(String[] args) {
        Car car = CarFactory.createCar(Integer.parseInt(args[1]), args[2], args[3], args[4],
                Integer.parseInt(args[5]), Integer.parseInt(args[6]), Integer.parseInt(args[7]),
                Integer.parseInt(args[8]), Integer.parseInt(args[9]));

        this.repository.save(car);
    }
}
