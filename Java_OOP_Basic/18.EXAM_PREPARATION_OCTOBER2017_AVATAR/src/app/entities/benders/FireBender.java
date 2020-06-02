package app.entities.benders;

public class FireBender extends Bender {

    private double heatAggeression;

    public FireBender(String name, int power, double heatAggeression) {
        super(name, power);
        this.heatAggeression = heatAggeression;
    }

    @Override
    public String toString() {
        return String.format("Fire Bender: %s, Power: %d, Heat Aggression: %.2f", super.getName(), super.getPower(), this.heatAggeression);
    }
}
