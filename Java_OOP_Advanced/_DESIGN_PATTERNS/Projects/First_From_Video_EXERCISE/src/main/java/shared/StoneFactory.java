package shared;

import model.GameObject;
import model.Stone;

public class StoneFactory implements Factory {

    @Override
    public GameObject produce() {
        return new Stone();
    }
}
