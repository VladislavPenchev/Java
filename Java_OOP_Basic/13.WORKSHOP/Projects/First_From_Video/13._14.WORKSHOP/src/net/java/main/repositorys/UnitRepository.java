package net.java.main.repositorys;

import net.java.main.constants.ExceptionMessagesConstants;
import net.java.main.exceptions.NoUnitToRemoveException;
import net.java.main.interfaces.Repository;
import net.java.main.interfaces.Unit;

import java.util.*;

public class UnitRepository implements Repository<Unit> {

    private Map<String, Unit> units;

    public UnitRepository() {
        this.units = new HashMap<>();
    }

    @Override
    public void save(Unit unit) {
        this.units.put(unit.getName(), unit);
    }

    @Override
    public void remove(Unit unit) throws NoUnitToRemoveException {
        if(!this.units.containsKey(unit.getName())){
            throw new NoUnitToRemoveException(ExceptionMessagesConstants.NO_UNIT_TO_REMOVE_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public Collection<Unit> findAll() {
        return this.units.values();
    }
}
