package app.entities.cells.microbes;

public class Virus extends Microbe {

    public Virus(String id, int health, int positionRow, int positionCow) {
        super(id, health, positionRow, positionCow);
    }

    @Override
    public int getEnergy() {
        return super.getHealth() + super.getVirulence();

    }

    @Override
    public String toString() {
        return String.format("%s--------Health: %d | Virulence: %d | Energy: %d%n", super.toString(), super.getHealth(), this.getVirulence(), this.getEnergy());
    }
}
