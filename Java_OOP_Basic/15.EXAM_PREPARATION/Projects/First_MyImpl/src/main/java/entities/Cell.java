package entities;

public abstract class Cell extends BaseEntity {

    private int health;
    private int positionRow;
    private int positionCol;

    protected Cell(String id, int health, int positionRow, int positionCol) {
        super(id);
        this.health = health;
        this.positionRow = positionRow;
        this.positionCol = positionCol;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPositionRow() {
        return positionRow;
    }

    public void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    public int getPositionCol() {
        return positionCol;
    }

    public void setPositionCol(int positionCol) {
        this.positionCol = positionCol;
    }

    public abstract int setEnergy();

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(System.lineSeparator())
                .append(String.format("------Cell %s [%d,%d]", this.getId(), this.getPositionRow(), this.getPositionCol()))
                .append(System.lineSeparator())
                .append(String.format("--------Health: %d",this.getHealth()));

        return res.toString();
    }
}
