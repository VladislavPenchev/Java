package app.entities;

import app.entities.benders.Bender;
import app.entities.monuments.Monument;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Nation {

    private List<Bender> benders;
    private List<Monument> monuments;

    public Nation(){
        benders = new ArrayList<>();
        monuments = new ArrayList<>();
    }

    public List<Bender> getBenders() {
        return Collections.unmodifiableList(this.benders);
    }

    public List<Monument> getMonuments() {
        return Collections.unmodifiableList(this.monuments);
    }

    @Override
    public String toString() {
        String nationType ="";

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s Nation%n", nationType))
            .append(String.format("Benders:%n"));

        for (Bender bender : this.benders) {
            sb.append(String.format("###"))
                    .append(bender)
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }
}
