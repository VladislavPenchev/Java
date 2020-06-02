package entities;

public class RedBloodCell extends BloodCell {
    private int velocity;

    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        this.velocity = velocity;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    @Override
    public int setEnergy() {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(super.toString());
        res.append(String.format(" | Velocity %d", this.getVelocity()));

        return res.toString();
    }
}
