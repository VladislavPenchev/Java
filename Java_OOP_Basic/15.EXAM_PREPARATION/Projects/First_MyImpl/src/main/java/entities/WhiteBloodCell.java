package entities;

public class WhiteBloodCell extends BloodCell {
    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int setEnergy() {
        return (super.getHealth() + this.size) * 2;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(super.toString());
        res.append(String.format(" | Size: %d | Energy: %d", this.getSize(), this.setEnergy()));

        return res.toString();
    }
}
