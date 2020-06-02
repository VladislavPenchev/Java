import commands.CommandDispatcher;
import domain.cars.Car;
import domain.races.Race;
import io.ConsoleReader;
import io.ConsoleWriter;
import io.Reader;
import io.Writter;
import repositories.CarRepository;
import repositories.RaceRepository;
import repositories.Repository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader consoleReader = new ConsoleReader();
        Writter consoleWriter = new ConsoleWriter();

        Repository<Car> carRepository = new CarRepository();
        Repository<Race> raceRepository = new RaceRepository();

        CommandDispatcher commandDispatcher = new CommandDispatcher(carRepository, raceRepository);

        Engine engine = new EngineImpl(consoleReader, consoleWriter, commandDispatcher);
        engine.run();
    }
}
