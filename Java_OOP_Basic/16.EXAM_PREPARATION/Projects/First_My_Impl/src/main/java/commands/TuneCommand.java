package commands;

import domain.Garage;
import domain.cars.Car;
import domain.cars.Performance;
import domain.cars.ShowCar;
import domain.races.Race;
import repositories.Repository;

public class TuneCommand implements Command{

    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public TuneCommand(Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public void execute(String[] args) {

        int tunedIndex = Integer.parseInt(args[1]);
        String addOn = args[2];

        Garage garage = Garage.getInstance();

        for (Car parkedCar : garage.getParkedCars()) {
            parkedCar.tuneCar(tunedIndex);

            if(parkedCar.getBrand().equals("Performance")){
                Performance performanceCar = (Performance) parkedCar;
                performanceCar.insertAddOns(addOn);
            }else {
                ShowCar showCar = (ShowCar) parkedCar;
                showCar.increaseStars(tunedIndex);
            }
        }

    }
}
