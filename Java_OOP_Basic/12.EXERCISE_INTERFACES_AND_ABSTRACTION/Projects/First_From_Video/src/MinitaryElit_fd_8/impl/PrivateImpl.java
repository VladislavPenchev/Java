package MinitaryElit_fd_8.impl;

import MinitaryElit_fd_8.contracts.Private;


public class PrivateImpl extends SoldierImpl implements Private {

    private double salary;

    public PrivateImpl(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s Salary: %s", super.toString(), this.salary);
    }
}
