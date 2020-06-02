package net.models.spells;

import net.interfaces.Spell;

public abstract class BaseSpell implements Spell {
    private final int DAMAGE = 15;

    private int damage;
    private int energyCost;

    protected BaseSpell(int energyCost) {
        this.damage = this.DAMAGE;
        this.energyCost = energyCost;
    }

    public int getDamage() {
        return this.damage;
    }


    public int getEnergyCost() {
        return this.energyCost;
    }
}
