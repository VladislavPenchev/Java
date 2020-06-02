package net.models.units;

import net.constants.GameConstants;
import net.interfaces.CombatHandler;
import net.interfaces.Position;

public class Marine extends BaseUnit {
    protected Marine(String name, Position position, CombatHandler combatHandler) {
        super(name, GameConstants.MARINE_RANGE, position, GameConstants.CARRIER_HEALTH_POINTS, GameConstants.MARINE_ENERGY_POINTS,
                GameConstants.MARINE_ATTACK_POINTS, GameConstants.MARINE_DEFENCE_POINTS, combatHandler);
    }
}
