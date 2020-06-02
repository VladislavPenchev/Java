package net.java.main.repository;

import net.java.main.constants.ExceptionMessagesConstants;
import net.java.main.exceptions.NoUnitToRemoveException;
import net.java.main.interfaces.Repository;
import net.java.main.interfaces.Unit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnitRepository implements Repository<Unit> {

    Map<String, Unit> repository;

    public UnitRepository() {
        this.repository = new HashMap<>();
    }


    @Override
    public void save(Unit element) {
        this.repository.putIfAbsent(element.getName(), element);
    }

    @Override
    public void remove(Unit element) throws NoUnitToRemoveException {
        if(this.repository.containsKey(element.getName())) {
            throw new NoUnitToRemoveException(ExceptionMessagesConstants.NO_UNIT_TO_REMOVE_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public List<Unit> findAll() {
        return (List) this.repository.keySet();
    }
}
