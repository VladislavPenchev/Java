package repositories;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseRepository<E> implements Repository<E> {
    private Map<Integer, E> coll;

    protected BaseRepository() {
        this.coll = new HashMap<>();
    }

    @Override
    public void save(E object) {
        int value = getIdReflect(object);

        this.coll.putIfAbsent(value, object);
    }

    @Override
    public void remove(E object) {
        int value = getIdReflect(object);

        if (!this.coll.containsKey(value)) {
            throw new IllegalArgumentException();
        }

        this.coll.remove(object);
    }

    @Override
    public Collection<E> findAll() {
        return this.coll.values();
    }

    @Override
    public E findById(int id) {
        return this.coll.get(id);
    }

    private int getIdReflect(E object) {
        Field field = null;
        int value = 0;
        try {
            field = object.getClass().getDeclaredField("id");
            field.setAccessible(true);
            value = (int) field.get(object);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return value;
    }
}
