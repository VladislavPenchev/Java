package net.java.main.models.units;

import net.java.main.constants.Constants;
import net.java.main.interfaces.CombatHandler;
import net.java.main.interfaces.Position;

public class Carrier extends BaseUnit{

    public Carrier(String name,
                   Position position,
                   CombatHandler combatHandler) {
        super(name,
                Constants.CARRIER_RANGE,
                position,
                Constants.CARRIER_HEALTH_POINTS,
                Constants.CARRIER_ENERGY_POINTS,
                Constants.CARRIER_ATTACK_POINTS,
                Constants.CARRIER_DEFENCE_POINTS,
                combatHandler);
    }

}
