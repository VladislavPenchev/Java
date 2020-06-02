package softuni.demo.dtos;

public class EmployeeDTO {
    private long id;
    private String firstName;
    private String lastName;
    private DepartmentDTO department;

    public long getId() {
        return this.id;
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

    public DepartmentDTO getDepartment() {
        return this.department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departmentName='" + department + '\'' +
                '}';
    }
}
