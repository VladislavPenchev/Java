package net.java.main.factories;

import net.java.main.enums.UnitType;
import net.java.main.handlers.CarrierCombatUnit;
import net.java.main.interfaces.Unit;
import net.java.main.models.PositionImpl;
import net.java.main.models.units.Carrier;
import net.java.main.models.units.Marine;

public class UnitFactory {

    public Unit createUnit(String[] args){
        if(UnitType.CARRIER.toString().equals(args[0])){
            return new Carrier(args[1],
                    new PositionImpl(Integer.parseInt(args[2]),
                            Integer.parseInt(args[3])),
                    new CarrierCombatUnit());
        }else if(UnitType.MARINE.toString().equals(args[0])){
            return new Marine(args[1],
                    new PositionImpl(Integer.parseInt(args[2]),
                            Integer.parseInt(args[3])),
                    new CarrierCombatUnit());
        }
    }
}
