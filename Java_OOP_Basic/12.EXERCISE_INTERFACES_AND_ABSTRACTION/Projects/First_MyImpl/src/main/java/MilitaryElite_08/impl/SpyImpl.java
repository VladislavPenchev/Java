package MilitaryElite_08.impl;

import MilitaryElite_08.contracts.Spy;

public class SpyImpl extends SoldierImpl implements Spy {

    private String codeNumber;

    public SpyImpl(String id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        StringBuilder spy = new StringBuilder(super.toString()).append(System.lineSeparator());
        spy.append(String.format("Code Number: %s", this.codeNumber));
        return spy.toString();
    }
}
