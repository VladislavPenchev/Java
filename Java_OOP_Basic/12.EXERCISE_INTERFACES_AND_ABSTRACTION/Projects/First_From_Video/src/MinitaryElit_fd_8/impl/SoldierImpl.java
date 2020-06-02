package MinitaryElit_fd_8.impl;

import MinitaryElit_fd_8.contracts.Soldier;

public abstract class SoldierImpl implements Soldier {
    private String id;
    private String firstName;
    private String lastName;

    protected SoldierImpl(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %s",this.firstName, this.lastName, this.lastName);
    }
}
