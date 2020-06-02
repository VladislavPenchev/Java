package softuni.demo.dtos;

public class DepartmentDTO {

    private String name;
    private int employeesCount;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeesCount() {
        return this.employeesCount;
    }

    public void setEmployeesCount(int employeesCount) {
        this.employeesCount = employeesCount;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "name='" + name + '\'' +
                ", employeesCount=" + employeesCount +
                '}';
    }
}
