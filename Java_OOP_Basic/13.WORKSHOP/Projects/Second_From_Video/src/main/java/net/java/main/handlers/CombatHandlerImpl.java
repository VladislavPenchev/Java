package net.java.main.handlers;

import net.java.main.interfaces.CombatHandler;
import net.java.main.interfaces.Unit;
import net.java.main.models.units.BaseUnit;

public abstract class CombatHandlerImpl implements CombatHandler{
    //TODO
    private Unit unit;

    protected CombatHandlerImpl() {
    }

    @Override
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    protected Unit getUnit() {
        return this.unit;
    }
}
