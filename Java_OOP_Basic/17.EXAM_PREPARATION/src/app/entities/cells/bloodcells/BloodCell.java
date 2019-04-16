package app.entities.cells.bloodcells;

import app.contracts.Cell;
import app.entities.cells.BaseCell;

public abstract class BloodCell extends BaseCell implements Cell {


    protected BloodCell(String id, int health, int positionRow, int positionCow) {
        super(id, health, positionRow, positionCow);
    }
}
