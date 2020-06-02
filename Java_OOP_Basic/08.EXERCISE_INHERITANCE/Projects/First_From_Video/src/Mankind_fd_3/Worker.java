package Mankind_fd_3;

public class Worker extends Human {

    private static final String INVALID_LASTNAME_MORE_THAN_3_SYMBOLS_EXCEPTION_MESSAGE = "Expected length more than 3 symbols!Argument: lastName";
    private static final String INVALID_WEEK_SALARY_MORE_THAN_10_EXCEPTION_MESSAGE = "Expected value mismatch!Argument: weekSalary";
    private static final String INVALID_WORKING_HOURS_RANGE_EXCEPTION_MESSAGE = "Expected value mismatch!Argument: workHoursPerDay";
    private static final int NUMBER_DAYS_OF_WEEK = 7;


    private double weekSalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    @Override
    protected void setLastName(String lastName) {
        if(lastName.length() < 3)
            throw new IllegalArgumentException(this.INVALID_LASTNAME_MORE_THAN_3_SYMBOLS_EXCEPTION_MESSAGE);

        super.setLastName(lastName);
    }

    public double getWeekSalary() {
        return this.weekSalary;
    }

    private void setWeekSalary(double weekSalary) {
        if(weekSalary < 10)
            throw new IllegalArgumentException(this.INVALID_WEEK_SALARY_MORE_THAN_10_EXCEPTION_MESSAGE);
        this.weekSalary = weekSalary;
    }

    public double getWorkHoursPerDay() {
        return this.workHoursPerDay;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if(workHoursPerDay < 1 || workHoursPerDay > 12)
            throw new IllegalArgumentException(this.INVALID_WORKING_HOURS_RANGE_EXCEPTION_MESSAGE);

        this.workHoursPerDay = workHoursPerDay;
    }

    public double getSalaryPerHour(){
        return (this.getWeekSalary() / this.NUMBER_DAYS_OF_WEEK) / this.getWorkHoursPerDay();
    }



    @Override
    public String toString() {
        StringBuilder worker = new StringBuilder();

        worker.append(super.toString())
                .append(String.format("Week Salary: %.2f", this.getWeekSalary()))
                .append(System.lineSeparator())
                .append(String.format("Hours per day: %.2f", this.getWorkHoursPerDay()))
                .append(System.lineSeparator())
                .append(String.format("salary per hour: %.2f", this.getSalaryPerHour()));

        return worker.toString();
    }
}
