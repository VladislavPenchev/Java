package factories;

import commands.*;
import domain.cars.BaseCar;
import domain.cars.Car;
import domain.races.BaseRace;
import domain.races.Race;
import repositories.Repository;

public final class CommandFactory {

    public static Command createCommand(String commandType, Repository<Car> carRepository, Repository<Race> raceRepository){
        switch (commandType) {
            case "register":
                return new RegisterCommand(carRepository);
            case "check":
                return new CheckCommand(carRepository);
            case "open":
                return new OpenCommand(raceRepository);
            case "participate":
                return new ParticipateCommand(carRepository, raceRepository);
            case "start":
                return null;
            case "park":
                return new ParkCommand(carRepository);
            case "unpark":
                return new UnpackCommand(carRepository);
            case "tune":
                return new TuneCommand(carRepository, raceRepository);
            default: return null;
        }
    }
}
