package Mankind_fd_3;

public class Student extends Human{
    private static final String INVALID_FACULTY_NUMBER_EXCEPTION_MESSAGE = "Invalid faculty number!";
    private static final int MIN_FACULTY_NUMBER_VALUE = 5;
    private static final int MAX_FACULTY_NUMBER_VALUE = 10;

    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    private String getFacultyNumber() {
        return this.facultyNumber;
    }

    private void setFacultyNumber(String facultyNumber) {
        if(facultyNumber.length() < this.MIN_FACULTY_NUMBER_VALUE || facultyNumber.length() > this.MAX_FACULTY_NUMBER_VALUE)
            throw new IllegalArgumentException(this.INVALID_FACULTY_NUMBER_EXCEPTION_MESSAGE);
        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        StringBuilder student = new StringBuilder();

        student.append(super.toString())
                .append(String.format("Faculty number: %s", this.getFacultyNumber()));

        return student.toString();
    }
}
