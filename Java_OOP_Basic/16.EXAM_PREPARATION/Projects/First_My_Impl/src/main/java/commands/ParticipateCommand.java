package commands;

import domain.cars.BaseCar;
import domain.cars.Car;
import domain.races.BaseRace;
import domain.races.Race;
import repositories.Repository;

public class ParticipateCommand implements Command{

    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ParticipateCommand(Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public void execute(String[] args) {
        Car car = this.carRepository.findById(Integer.parseInt(args[0]));

        Race race = this.raceRepository.findById(Integer.parseInt(args[1]));

        race.addParticipant(car);

    }
}
