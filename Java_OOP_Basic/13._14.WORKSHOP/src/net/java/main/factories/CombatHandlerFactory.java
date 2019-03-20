package net.java.main.factories;

import net.java.main.handlers.CarrierCombatHandler;
import net.java.main.handlers.MarineCombatHandler;
import net.java.main.interfaces.CombatHandler;

public final class CombatHandlerFactory {

    private CombatHandlerFactory(){

    }

    public static CombatHandler createCarrierCombatHandler(){
                return new CarrierCombatHandler();
        }

    public static CombatHandler createMarineCombatHandler(){
        return new MarineCombatHandler();
    }




}


