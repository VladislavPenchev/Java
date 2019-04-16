package app.entities.cells;

import app.contracts.Cell;

public abstract class BaseCell implements Cell {
    private String id;
    private int health;
    private int positionRow;
    private int positionCow;

    protected BaseCell(String id, int health, int positionRow, int positionCow) {
        this.id = id;
        this.health = health;
        this.positionRow = positionRow;
        this.positionCow = positionCow;
    }

    public String getId() {
        return this.id;
    }

    public int getHealth() {
        return this.health;
    }

    public int getPositionRow() {
        return this.positionRow;
    }

    public int getPositionCow() {
        return this.positionCow;
    }

    public abstract int getEnergy();

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    public void setPositionCow(int positionCow) {
        this.positionCow = positionCow;
    }

    @Override
    public String toString() {
        return String.format("------Cell %s [%d,%d]%n", this.id, this.positionRow, this.positionCow);
    }
}
