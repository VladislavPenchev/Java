package commands;

import domain.cars.Car;
import domain.races.Race;
import factories.CommandFactory;
import repositories.Repository;

import java.util.HashMap;
import java.util.Map;

public class CommandDispatcher {

    private Map<String, Command> commands;

    public CommandDispatcher(Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.commands = new HashMap<>();
        this.seedCommands(carRepository, raceRepository);
    }

    public void dispatch(String line) {
        String[] lineArgs = line.split("\\s+");

        if (this.commands.containsKey(lineArgs[0])) {
            this.commands.get(lineArgs[0]).execute(lineArgs);
        }

        throw new IllegalArgumentException();
    }

    private void seedCommands(Repository<Car> carRepository, Repository<Race> raceRepository) {
        commands.put("register", CommandFactory.createCommand("register", carRepository, raceRepository));
        commands.put("check", CommandFactory.createCommand("check",carRepository, raceRepository));
        commands.put("open", CommandFactory.createCommand("open", carRepository, raceRepository));
        commands.put("participate", CommandFactory.createCommand("participate", carRepository, raceRepository));
        commands.put("start", CommandFactory.createCommand("start", carRepository, raceRepository));
        commands.put("park", CommandFactory.createCommand("park", carRepository, raceRepository));
        commands.put("unpark", CommandFactory.createCommand("unpark", carRepository, raceRepository));
        commands.put("tune", CommandFactory.createCommand("tune", carRepository, raceRepository));
    }

}
