package net.java.main.commands;

import net.java.main.constants.ExceptionMessagesConstants;
import net.java.main.enums.UnitType;
import net.java.main.exceptions.InvalidPositionException;
import net.java.main.exceptions.InvalidUnitTypeException;
import net.java.main.factories.UnitFactory;
import net.java.main.interfaces.Battleground;
import net.java.main.interfaces.Command;
import net.java.main.interfaces.Repository;
import net.java.main.interfaces.Unit;

public class SpawnCommand implements Command {

    private Battleground battleground;
    private Repository<Unit> unitRepository;


    public SpawnCommand(Battleground battleground, Repository<Unit> unitRepository) {
        this.battleground = battleground;
        this.unitRepository = unitRepository;
    }

    @Override
    public String execute(String[] args) throws InvalidUnitTypeException, InvalidPositionException {
        String typeUnit = args[0];
        UnitType unitType = null;

        try{
            unitType = UnitType.valueOf(typeUnit.toUpperCase());
        }catch(IllegalArgumentException iae){
            throw new InvalidUnitTypeException(ExceptionMessagesConstants.INVALID_UNIT_TYPE_EXCEPTION_MESSAGE);
        }

        String unitName = args[1];
        int xPosition = Integer.parseInt(args[2]);
        int yPosition = Integer.parseInt(args[3]);

        Unit unit = UnitFactory.createUnit(unitType, unitName, xPosition, yPosition);

        this.battleground.add(unit);
        this.unitRepository.save(unit);

        return String.format("");
    }
}
