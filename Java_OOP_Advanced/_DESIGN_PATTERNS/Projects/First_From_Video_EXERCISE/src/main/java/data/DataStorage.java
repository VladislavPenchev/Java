package data;

import model.Enemy;
import model.Player;

import java.util.Map;

public class DataStorage {

    private Map<Class<?>, int[]> objectsData = Map.of(
            Player.class, new int[] {100, 24},
            Enemy.class, new int[] {200, 2}
    );

    public int[] load(Class<?> clazz){
        return this.objectsData.get(clazz);
    }

}
