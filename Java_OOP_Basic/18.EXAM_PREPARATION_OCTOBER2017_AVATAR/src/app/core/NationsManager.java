package app.core;

import app.entities.Nation;
import app.entities.benders.Bender;
import app.entities.monuments.Monument;
import app.factories.BenderFactory;
import app.factories.MonumentFactory;
import app.factories.NationFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class NationsManager {

    private Map<String, Nation> nations;

    public NationsManager(){
        nations = new LinkedHashMap<>();
    }

    public void benderCommands(String type, String name, int power, double secondoryParameter){

        Bender bender = BenderFactory.createBender(type,name,power,secondoryParameter);

        Nation nation = NationFactory.createNation();

        nation.getBenders().add(bender);

        nations.put(type,nation);

    }

    public void monumentCommand(String type, String name, int affinity){

        Monument monument = MonumentFactory.createMonument(type, name, affinity);
    }


    public String statusCommand(String nationType){

        if(this.nations.containsKey(nationType)){
            return this.nations.get(nationType).getBenders().get(0).toString();
        }
        return "";
    }

}
