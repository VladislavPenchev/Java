package models.attacks;

import interfaces.Attack;
import models.Blob;

public class PutridFart implements Attack {

    public void execute(Blob source, Blob target) {
        int currentHealth = target.getHealth();
        currentHealth -= source.getDamage();
        target.setHealth(currentHealth);
    }
}
