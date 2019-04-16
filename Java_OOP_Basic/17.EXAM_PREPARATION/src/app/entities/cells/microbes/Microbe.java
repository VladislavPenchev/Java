package app.entities.cells.microbes;

import app.contracts.Cell;
import app.entities.cells.BaseCell;

public abstract class Microbe extends BaseCell implements Cell {

    private int virulence;

    protected Microbe(String id, int health, int positionRow, int positionCow) {
        super(id, health, positionRow, positionCow);
    }

    public int getVirulence() {
        return this.virulence;
    }
}
