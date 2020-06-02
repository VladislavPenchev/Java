package net.java.main.handlers;

import net.java.main.interfaces.CombatHandler;
import net.java.main.interfaces.Unit;
import net.java.main.models.units.BaseUnit;

public abstract class BaseCombatHandler implements net.java.main.interfaces.CombatHandler {
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
}
