package commands;

import domain.cars.BaseCar;
import domain.cars.Car;
import repositories.Repository;

public class CheckCommand implements Command{

    private Repository<Car> repository;

    public CheckCommand(Repository<Car> repository) {
        this.repository = repository;
    }

    @Override
    public void execute(String[] args) {
        Car car =  repository.findById(Integer.parseInt(args[1]));

        System.out.println(car.toString());
    }
}
