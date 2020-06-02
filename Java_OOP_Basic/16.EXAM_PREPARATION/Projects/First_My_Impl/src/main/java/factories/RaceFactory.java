package factories;

import domain.races.BaseRace;
import domain.races.CasualRace;
import domain.races.DragRace;
import domain.races.DriftRace;
import repositories.RaceRepository;

public final class RaceFactory {

    private RaceRepository raceRepository;

    public RaceFactory(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public static BaseRace createRace(int id, String type, int length, String route, int prizePool) {
        switch (type) {
            case "Casual":
                return new CasualRace(id, length, route, prizePool);
            case "Drag":
                return new DragRace(id, length, route, prizePool);
            case "Drift":
                return new DriftRace(id, length, route, prizePool);
            default:
                return null;
        }
    }
}
