package app.factories;

import app.entities.Nation;

public final class NationFactory {

    private NationFactory(){

    }

    public static Nation createNation(){
        return new Nation();
    }
}
