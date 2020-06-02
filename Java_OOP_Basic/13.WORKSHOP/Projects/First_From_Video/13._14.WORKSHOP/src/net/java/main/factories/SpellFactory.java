package net.java.main.factories;

import net.java.main.enums.SpellType;
import net.java.main.interfaces.Spell;
import net.java.main.models.spells.BulletRain;
import net.java.main.models.spells.RageShoot;

public class SpellFactory {

    public Spell createSpell(SpellType type , int energyCost){
        switch (type){
            case RAGESHOOT: return new RageShoot(energyCost);
            case BULLET_RAIN: return new BulletRain(energyCost);
            default: return  null;
        }
    }


}
