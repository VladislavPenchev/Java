package repositories;

import java.util.Collection;

public interface Repository<T> {

    void save(T element);

    void remove(T element);

    Collection<T> findAll();

    T findById(int id);
}
