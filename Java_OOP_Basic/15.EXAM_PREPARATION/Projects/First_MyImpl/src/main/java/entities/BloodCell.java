package entities;

public abstract class BloodCell extends Cell{

    protected BloodCell(String id, int health, int positionRow, int positionCol) {
        super(id, health, positionRow, positionCol);
    }
}
