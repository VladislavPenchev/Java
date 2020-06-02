package MinitaryElit_fd_8.impl;

import MinitaryElit_fd_8.contracts.Engineer;
import MinitaryElit_fd_8.contracts.Private;
import MinitaryElit_fd_8.contracts.Repair;

import java.util.Set;
import java.util.stream.Collectors;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {

    private Set<Repair> repairs;

    public EngineerImpl(String id, String firstName, String lastName, double salary, String corps, Set<Repair> repairs) {
        super(id, firstName, lastName, salary, corps);

        this.repairs = repairs;
    }

    @Override
    public String toString() {
        StringBuilder engineer = new StringBuilder(super.toString()).append(System.lineSeparator());

        engineer
                .append("Repairs: ");

        for (Repair repair : this.repairs) {
            engineer.append(System.lineSeparator())
                    .append(repair);
        }

        return  engineer.toString();
    }
}
