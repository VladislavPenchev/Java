package net.java.main.interfaces;

import net.java.main.exceptions.NoUnitToRemoveException;

import java.util.List;

public interface Repository<Unit> {

    void save(Unit element);

    void remove(Unit element) throws NoUnitToRemoveException;

    List<Unit> findAll();
}
