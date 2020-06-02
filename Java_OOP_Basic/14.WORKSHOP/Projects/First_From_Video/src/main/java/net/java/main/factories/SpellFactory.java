package net.java.main.factories;

import net.java.main.enums.SpellType;
import net.java.main.interfaces.Spell;
import net.java.main.models.spells.BulletRain;
import net.java.main.models.spells.RageShoot;

public final class SpellFactory {

    private SpellFactory() {
    }

    public static Spell createSpell(SpellType type, int energyCost) {
        switch (type) {
            case RAGE_SHOOT:
                return new RageShoot(energyCost);
            case BULLET_RAIN:
                return new BulletRain(energyCost);
            default:
                return null;
        }
    }
}
