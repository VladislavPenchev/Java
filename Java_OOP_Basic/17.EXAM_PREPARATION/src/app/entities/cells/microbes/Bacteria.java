package app.entities.cells.microbes;

public class Bacteria extends Microbe {

    public Bacteria(String id, int health, int positionRow, int positionCow) {
        super(id, health, positionRow, positionCow);
    }

    @Override
    public int getEnergy() {
        return (super.getVirulence() + super.getVirulence()/3);
    }

    @Override
    public String toString() {
        return String.format("%s--------Health: %d | Virulence: %d | Energy: %d%n", super.toString(), super.getHealth(), this.getVirulence(), this.getEnergy());
    }
}
