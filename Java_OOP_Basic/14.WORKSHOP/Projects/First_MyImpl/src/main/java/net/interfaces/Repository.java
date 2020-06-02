package net.interfaces;

import net.exceptions.NoUnitToRemoveException;

import java.util.Collection;

public interface Repository<T> {
    void save(T element);

    void remove(T element) throws NoUnitToRemoveException;

    Collection<T> findAll();

    T findByName(String name);
}
