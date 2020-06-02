package MinitaryElit_fd_8.impl;

import MinitaryElit_fd_8.contracts.LeutenantGeneral;
import MinitaryElit_fd_8.contracts.Private;

import java.util.Set;
import java.util.stream.Collectors;

public class LeutenantGeneralImpl extends PrivateImpl implements LeutenantGeneral {

    private Set<Private> privates;

    public LeutenantGeneralImpl(String id, String firstName, String lastName, double salary, Set<Private> privates) {
        super(id, firstName, lastName, salary);
        this.privates = privates;
    }



    @Override
    public String toString() {
        StringBuilder leutenantGeneral = new StringBuilder(super.toString()).append(System.lineSeparator());

        leutenantGeneral
                .append("Privates: ");

        Set<Private> sortedPrivates = this.privates
                .stream()
                .sorted((p1,p2) -> p2.getId().compareTo(p1.getId()))
                .collect(Collectors.toSet());

        for (Private privateSoldier : this.privates) {
            leutenantGeneral.append(System.lineSeparator())
                    .append(privateSoldier);
        }

        return leutenantGeneral.toString();
    }
}
