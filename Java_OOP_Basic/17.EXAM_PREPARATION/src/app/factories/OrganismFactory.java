package app.factories;

import app.entities.OrganismImpl;

public class OrganismFactory {

    private OrganismFactory(){

    }

    public static OrganismImpl createOrganism(String name){
        return new OrganismImpl(name);
    }

}
