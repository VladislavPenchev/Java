package net.models.units;

import net.constants.GameConstants;
import net.interfaces.CombatHandler;
import net.interfaces.Position;

public class Carrier extends BaseUnit {
    protected Carrier(String name, Position position, CombatHandler combatHandler) {
        super(name, GameConstants.CARRIER_RANGE, position, GameConstants.CARRIER_HEALTH_POINTS, GameConstants.CARRIER_ENERGY_POINTS,
                GameConstants.CARRIER_ATTACK_POINTS, GameConstants.CARRIER_DEFENCE_POINTS, combatHandler);
    }
}
