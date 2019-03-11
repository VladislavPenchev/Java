package Person_fd_1;

public class Person {
    private static final String INVALID_NAME_EXCEPTION_MESSAGE = "Name's length should not be less than 3 symbols!";
    private static final String INVALID_NEGATIVE_AGE_EXCEPTION_MESSAGE = "Age must be positive!";

    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private String getName() {
        return this.name;
    }

    protected void setName(String name) {
        if(name.length() < 3)
            throw new IllegalArgumentException(this.INVALID_NAME_EXCEPTION_MESSAGE);
        this.name = name;
    }

    private int getAge() {
        return this.age;
    }

    protected void setAge(int age) {
        if(age < 1)
            throw new IllegalArgumentException(this.INVALID_NEGATIVE_AGE_EXCEPTION_MESSAGE);
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d",this.getName(),this.getAge());
    }
}
