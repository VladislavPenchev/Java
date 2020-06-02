package entities;

public abstract class Microbe extends Cell {
    private int virulence;

    public Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }

    public int getVirulence() {
        return virulence;
    }

    public void setVirulence(int virulence) {
        this.virulence = virulence;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(super.toString());
        res.append(String.format(" | Virulence %d", this.getVirulence()));

        return res.toString();
    }
}
