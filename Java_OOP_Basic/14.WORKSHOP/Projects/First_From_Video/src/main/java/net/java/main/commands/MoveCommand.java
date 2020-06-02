package net.java.main.commands;

import net.java.main.exceptions.GameException;
import net.java.main.exceptions.UnitNotExistException;
import net.java.main.interfaces.Battleground;
import net.java.main.interfaces.Command;
import net.java.main.interfaces.Repository;
import net.java.main.interfaces.Unit;
import net.java.main.repository.UnitRepository;

public class MoveCommand implements Command {
    private Battleground battleground;
    private Repository<Unit> unitRepository;

    public MoveCommand(Battleground battleground, Repository<Unit> unitRepository) {
        this.battleground = battleground;
        this.unitRepository = unitRepository;
    }

    @Override
    public String execute(String[] args) throws GameException {
        String unitName = args[1];
        int xPosition = Integer.parseInt(args[2]);
        int yPosition = Integer.parseInt(args[3]);

        Unit unit = this.unitRepository.findByName(unitName);

        if(unit == null) {
            throw new UnitNotExistException(String.format("Not exist unit with name %s!", unitName));
        }

        this.battleground.move(unit, xPosition, yPosition);

        return String.format("%s moved to %s", unit.getName(), unit.getPosition().toString());
    }
}
