package commands;

import domain.races.BaseRace;
import domain.races.Race;
import factories.RaceFactory;
import repositories.RaceRepository;
import repositories.Repository;

public class OpenCommand implements Command {

    private Repository<Race> raceRepository;

    public OpenCommand(Repository<Race> raceRepository) {
        this.raceRepository = raceRepository;
    }

    @Override
    public void execute(String[] args) {
        Race race = RaceFactory.createRace(Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]),
                args[4], Integer.parseInt(args[5]));

        this.raceRepository.save(race);
    }
}
