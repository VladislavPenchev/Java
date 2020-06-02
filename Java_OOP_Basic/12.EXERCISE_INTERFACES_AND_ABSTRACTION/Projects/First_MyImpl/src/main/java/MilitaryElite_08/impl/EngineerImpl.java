package MilitaryElite_08.impl;

import MilitaryElite_08.contracts.Engineer;
import MilitaryElite_08.contracts.Private;
import MilitaryElite_08.contracts.Repaire;

import java.util.Set;
import java.util.stream.Collectors;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {

    private Set<Repaire> repaires;

    public EngineerImpl(String id, String firstName, String lastName, double salary, String corps, Set<Repaire> repaires) {
        super(id, firstName, lastName, salary, corps);
        this.repaires = repaires;
    }

    @Override
    public String toString() {
        StringBuilder engineer = new StringBuilder(super.toString()).append(System.lineSeparator());
        engineer.append("Repairs:");

        for (Repaire repaire : this.repaires) {
            engineer.append(System.lineSeparator())
                    .append("  " + repaire);
        }
        return engineer.toString();
    }
}
