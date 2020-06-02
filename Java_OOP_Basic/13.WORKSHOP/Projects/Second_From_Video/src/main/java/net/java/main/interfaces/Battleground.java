package net.java.main.interfaces;

import net.java.main.exceptions.InvalidPositionException;
import net.java.main.models.units.BaseUnit;

import java.util.List;

public interface Battleground {

    List<BaseUnit> getUnitsInRange(int xPosition, int yPosition, int range);

    void add(BaseUnit unit) throws InvalidPositionException;

    void remove(BaseUnit unit) throws InvalidPositionException;

    void move(BaseUnit unit, int xPosition, int yPosition) throws InvalidPositionException;
}
