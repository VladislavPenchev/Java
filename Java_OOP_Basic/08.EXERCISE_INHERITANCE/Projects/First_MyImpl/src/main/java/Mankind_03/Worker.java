package Mankind_03;

import java.math.BigDecimal;

public class Worker extends Human{
    private BigDecimal weekSalary;
    private int workHoursPerDay;

    public Worker(String firstName, String lastName, BigDecimal weekSalary, int workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    @Override
    public void setLastName(String lastName) {
        if(lastName.length() <= 3){
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }
        super.setLastName(lastName);
    }

    public BigDecimal getWeekSalary() {
        return weekSalary;
    }

    public void setWeekSalary(BigDecimal weekSalary) {
        if(weekSalary.compareTo(new BigDecimal(10)) == -1){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    public int getWorkHoursPerDay() {
        return workHoursPerDay;
    }

    public void setWorkHoursPerDay(int workHoursPerDay) {
        if(workHoursPerDay <= 1 || workHoursPerDay >= 12){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(String.format("First Name: %s", this.getFirstName()))
                .append(System.lineSeparator())
                .append(String.format("Last Name: %s", this.getLastName()))
                .append(System.lineSeparator())
                .append(String.format("Week Salary: %.2f", this.getWeekSalary()))
                .append(System.lineSeparator())
                .append(String.format("Hours per day: %d.00", this.getWorkHoursPerDay()))
                .append(System.lineSeparator())
                .append(String.format("Salary per hour: %.2f", this.getSalaryPerHour()))
                .append(System.lineSeparator());
        return stringBuilder.toString();
    }

    private BigDecimal getSalaryPerHour() {
        return this.getWeekSalary().divide(new BigDecimal(this.getWorkHoursPerDay()));
    }
}
