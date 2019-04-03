package app.entities.races;

        import app.contracts.Car;
        import app.contracts.Race;

        import java.util.ArrayList;
        import java.util.Collection;

public abstract class BaseRace implements Race {
    private int length;
    private String route;
    private int prizePool;
    private Collection<Car> participants;

    protected BaseRace(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();

    }

    @Override
    public void addParticipant(Car car){
        this.participants.add(car);
    }

    @Override
    public boolean hasCar(Car car) {
        return this.participants.contains(car);
    }
}
