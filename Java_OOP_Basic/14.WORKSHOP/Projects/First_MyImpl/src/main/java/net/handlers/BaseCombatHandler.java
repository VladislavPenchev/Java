package net.handlers;


import net.interfaces.CombatHandler;
import net.interfaces.Unit;

import java.util.List;

public abstract class BaseCombatHandler implements CombatHandler {
    private final int CLOSEST_ENEMY = 0;
    private Unit unit;

    protected BaseCombatHandler() {
    }

    @Override
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    protected Unit getUnit() {
        return this.unit;
    }

    @Override
    public Unit pickNextTarget(List<Unit> targetCandidates) {

        return null;
    }
}
