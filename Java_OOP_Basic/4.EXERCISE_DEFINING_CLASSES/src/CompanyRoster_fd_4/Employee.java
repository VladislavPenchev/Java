package CompanyRoster_fd_4;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private Department department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, Department department){
        this(name,salary,position,department,"n/a");
    }

    public Employee(String name, double salary, String position, Department department,String email){
        this(name,salary,position,department,"n/a", -1);
    }

    public Employee(String name, double salary, String position, Department department,String email, int age){
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setAge(int age){
        this.age = age;
    }


}
