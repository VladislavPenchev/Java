package MilitaryElite_08.impl;

import MilitaryElite_08.contracts.Repaire;

public class RepaireImpl implements Repaire {
    private String partName;
    private int hoursWorked;

    public RepaireImpl(String partName, int hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d", this.partName, this.hoursWorked);
    }
}
