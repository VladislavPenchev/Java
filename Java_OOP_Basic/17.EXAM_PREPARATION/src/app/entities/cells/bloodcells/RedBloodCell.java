package app.entities.cells.bloodcells;


public class RedBloodCell extends BloodCell {

    private int velocity;

    public RedBloodCell(String id, int health, int positionRow, int positionCow, int velocity) {
        super(id, health, positionRow, positionCow);

        this.velocity = velocity;
    }

    public int getVelocity() {
        return this.velocity;
    }

    @Override
    public int getEnergy() {
        return super.getHealth() + this.velocity;
    }

    @Override
    public String toString() {
        return String.format("%s--------Health: %d | Velocity: %d | Energy: %d%n", super.toString(), super.getHealth(), this.getVelocity(), this.getEnergy());
    }
}
