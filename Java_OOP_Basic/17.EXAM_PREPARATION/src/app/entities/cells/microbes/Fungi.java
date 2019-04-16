package app.entities.cells.microbes;

public class Fungi extends Microbe {

    public Fungi(String id, int health, int positionRow, int positionCow) {
        super(id, health, positionRow, positionCow);
    }

    @Override
    public int getEnergy() {
        return (super.getVirulence() + super.getVirulence()/4);
    }

    @Override
    public String toString() {
        return String.format("%s--------Health: %d | Virulence: %d | Energy: %d%n", super.toString(), super.getHealth(), this.getVirulence(), this.getEnergy());
    }
}
