package net.java.main.handlers;

import net.java.main.interfaces.Spell;
import net.java.main.interfaces.Unit;
import net.java.main.models.units.BaseUnit;

import java.util.List;

public class MarineCombatHandler extends CombatHandlerImpl {
    private final int CLOSEST_ENEMY = 0;
    private final int HALF_MARINE_HEALTH = 25;

    //TODO:
    @Override
    public Unit pickNextTarget(List<Unit> targetCandidates) {
        return null;
    }

    @Override
    public Spell generateAttack() {
        return null;
    }
}
