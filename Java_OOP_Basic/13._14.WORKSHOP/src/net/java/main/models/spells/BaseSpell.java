package net.java.main.models.spells;

import net.java.main.interfaces.Spell;

public abstract class BaseSpell implements Spell {
    private final int DAMAGE = 15;

    private int damage;
    private int energyCost;

    protected BaseSpell(int energyCost) {
        this.damage = this.DAMAGE;
        this.energyCost = energyCost;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public int getEnergyCost() {
        return this.energyCost;
    }
}
