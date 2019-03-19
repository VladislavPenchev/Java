package net.java.main.interfaces;

import net.java.main.exceptions.NoUnitToRemoveException;

import java.util.Collection;
import java.util.List;

public interface Repository<T> {

    void save(T element);

    void remove(T element) throws NoUnitToRemoveException;

    Collection<T> findAll();
}
