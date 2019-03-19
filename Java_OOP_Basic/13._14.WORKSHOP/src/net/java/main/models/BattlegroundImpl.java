package net.java.main.models;

import net.java.main.constants.ExceptionMessagesConstants;
import net.java.main.exceptions.InvalidPositionException;
import net.java.main.interfaces.Battleground;
import net.java.main.interfaces.Position;
import net.java.main.interfaces.Unit;
import net.java.main.models.units.BaseUnit;

import java.util.ArrayList;
import java.util.List;

public class BattlegroundImpl implements Battleground {

    private Unit[][] battlegroud;

    public BattlegroundImpl(int rows, int cols){
        this.battlegroud = new Unit[rows][cols];
    }

    private void validateUnitPosition(int x, int y) throws InvalidPositionException {
        if(x < 0
                || x >= this.battlegroud.length
                || y < 0
                || y >= this.battlegroud[x].length ) {
                throw new InvalidPositionException(ExceptionMessagesConstants.INVALID_COORDINATES_EXCEPTION_MESSAGE);
        }
    }

    private void validateEmptyPosition(Unit unit) throws InvalidPositionException {
        if(unit != null){
            throw new InvalidPositionException(ExceptionMessagesConstants.POSITION_NOT_EMPTY_EXCEPTION_MESSAGE);
        }
    }


    @Override
    public List<Unit> getUnitsInRange(int xPosition, int yPosition, int range) {

        List<Unit> targetUnits = new ArrayList<>();

        int startRow = Math.max(0,xPosition - range);
        int endRow = Math.max(xPosition + range, battlegroud.length - 1);
        int startCol = Math.max(0,yPosition - range);
        int endCol = Math.max(yPosition + range, battlegroud[xPosition].length - 1);

        for(int i = startRow; i <= endRow; i++){
            for(int j = startCol; j <= endCol; j++){
                if(this.battlegroud[i][j] != null){
                    targetUnits.add(battlegroud[i][j]);
                }
            }
        }

        return targetUnits;
    }

    @Override
    public void add(Unit unit) throws InvalidPositionException {
        Position position = unit.getPosition();

        this.validateUnitPosition(position.getX(),position.getY());

        validateEmptyPosition(this.battlegroud[position.getX()][position.getY()]);

        this.battlegroud[position.getX()][position.getY()] = unit;
    }


    @Override
    public void remove(Unit unit) {
        Position position = unit.getPosition();
        this.battlegroud[position.getX()][position.getY()] = null;
    }

    @Override
    public void move(Unit unit, int xPosition, int yPosition) throws InvalidPositionException {

        Position position = unit.getPosition();

        this.validateUnitPosition(xPosition, yPosition);

        this.validateEmptyPosition(this.battlegroud[xPosition][yPosition]);

        this.battlegroud[xPosition][yPosition] = unit;
        this.battlegroud[position.getX()][position.getY()] = null;


    }
}
