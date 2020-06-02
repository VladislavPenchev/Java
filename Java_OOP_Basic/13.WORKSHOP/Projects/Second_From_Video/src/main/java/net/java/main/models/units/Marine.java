package net.java.main.models.units;

import net.java.main.constants.Constants;
import net.java.main.interfaces.CombatHandler;
import net.java.main.interfaces.Position;

public class Marine extends BaseUnit {

    public Marine(String name, Position position, CombatHandler combatHandler) {
        super(name, Constants.MARINE_RANGE, position, Constants.MARINE_HEALTH_POINTS, Constants.CARRIER_ENERGY_POINTS,
                Constants.MARINE_ATTACK_POINTS, Constants.MARINE_DEFENCE_POINTS, combatHandler);
    }

}
