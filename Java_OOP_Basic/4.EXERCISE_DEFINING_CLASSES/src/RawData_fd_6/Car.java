package RawData_fd_6;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tier> tiers;

    public Car(String model, Engine engine, Cargo cargo, List<Tier> tiers){
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tiers = tiers;
    }

    public Engine getEngine(){
        return this.engine;
    }

    public Cargo getCargo(){
        return this.cargo;
    }

    public List<Tier> getTiers() {
        return this.tiers;
    }

    @Override
    public String toString() {
        return String.format("%s",this.model);
    }
}
