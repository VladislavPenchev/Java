package SalaryIncrease_02;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double increaseSalary(double bonus){
        if(this.getAge() < 30) {
            bonus /=2;
        }

        double bonusInLeva = ((this.getSalary() * bonus) / 100);

        this.setSalary(bonusInLeva + this.getSalary());

        return bonusInLeva;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.2f leva", this.getFirstName(), lastName, this.getSalary());
    }
}
