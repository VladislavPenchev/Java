package MinitaryElit_fd_8.impl;

import MinitaryElit_fd_8.contracts.Spy;

public class SpyImpl extends SoldierImpl implements Spy {

    private String codeNumber;

    protected SpyImpl(String id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        StringBuilder spy = new StringBuilder(super.toString()).append(System.lineSeparator());
        spy.append(String.format("Code Number: %s",this.codeNumber));

        return spy.toString();
    }
}
