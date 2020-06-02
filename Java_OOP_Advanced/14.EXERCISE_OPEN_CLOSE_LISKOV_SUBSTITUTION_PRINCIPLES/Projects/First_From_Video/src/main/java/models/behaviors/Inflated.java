package models.behaviors;

import models.Blob;

public class Inflated extends AbstractBehavior{

    private static final int INFLATED_HEALTH_INCREMENT = 50;
    private static final int INFLATED_HEALTH_DECREMENT = 10;

    public void trigger(Blob source) {
        if(super.isTriggered()) {
            throw new IllegalStateException();
        }
        super.setIsTriggered(true);
        source.setHealth(source.getHealth() + INFLATED_HEALTH_INCREMENT);
    }

    public void applyRecurrentEffect(Blob source) {
        if (super.toDelayRecurrentEffect()) {
            super.setToDelayRecurrentEffect(false);
        } else {
            source.setHealth(source.getHealth() - INFLATED_HEALTH_DECREMENT);
        }
    }
}
