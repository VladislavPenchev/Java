package domain.races;

import domain.cars.BaseCar;
import domain.cars.Car;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRace implements Race{
    private int id;
    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    public BaseRace(int id, int length, String route, int prizePool) {
        this.id = id;
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
    }

    @Override
    public void addParticipant(Car participants) {
        this.participants.add(participants);
    }

    @Override
    public String toString() {
        StringBuilder baseRaceInfo = new StringBuilder();

        baseRaceInfo.append(String.format("%s %s", this.route, this.length))
                .append(System.lineSeparator());

        for (int i = 0; i < 3; i++) {
            baseRaceInfo.append(String.format("%d. %s %s %dPP - $%d", i + 1, this.participants.get(i).getBrand(),
                    this.participants.get(i).getModel(), 1, 1))
            .append(System.lineSeparator());
        }

        return baseRaceInfo.toString();
    }
}
