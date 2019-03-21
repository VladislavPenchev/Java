package Test_fd_0_1.repositories.base;

public class Employee {
    private long id;
    private String firstName;
    private String lastName;

    public Employee(){

    }

    public Employee(String firstName, String lastName) {
        this(0,firstName,lastName);
    }

    public Employee(long id, String firstName, String lastName) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
