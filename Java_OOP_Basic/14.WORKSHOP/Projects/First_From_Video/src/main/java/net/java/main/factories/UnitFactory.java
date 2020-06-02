package net.java.main.factories;

import net.java.main.enums.UnitType;
import net.java.main.exceptions.InvalidUnitTypeException;
import net.java.main.interfaces.Position;
import net.java.main.interfaces.Unit;
import net.java.main.models.PositionImpl;
import net.java.main.models.units.Carrier;
import net.java.main.models.units.Marine;

public final class UnitFactory {
    private UnitFactory() {
    }

    public static Unit createUnit(UnitType unitType, String name, int xPosition, int yPosition) {
        Position position = null;
        switch (unitType) {
            case MARINE:
                return new Marine(name, new PositionImpl(xPosition, yPosition), CombatHandlerFactory.createMarineCombatHandler());
            case CARRIER:
                return new Carrier(name, new PositionImpl(xPosition, yPosition), CombatHandlerFactory.createCarrierCombatHandler());
            default:
                return null;
        }
    }
}
