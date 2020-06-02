package entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "mothers")
public class Mother extends Person{

    private Person child;

    @OneToOne
    @JoinColumn(name = "child-id",
                referencedColumnName = "id")
    public Person getChild() {
        return this.child;
    }

    public void setChild(Person child) {
        this.child = child;
    }
}
