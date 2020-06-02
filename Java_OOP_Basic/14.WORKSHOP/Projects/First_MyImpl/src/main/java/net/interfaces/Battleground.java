package net.interfaces;


import net.exceptions.InvalidPositionException;

import java.util.List;

public interface Battleground {

    List<Unit> getUnitsInRange(int xPosition, int yPosition, int range);

    void add(Unit baseUnit) throws InvalidPositionException;

    void remove(Unit baseUnit) throws InvalidPositionException;

    void move(Unit baseUnit, int xPosition, int yPosition) throws InvalidPositionException;
}
