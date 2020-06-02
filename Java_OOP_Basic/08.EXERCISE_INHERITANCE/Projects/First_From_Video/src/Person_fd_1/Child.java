package Person_fd_1;

public class Child extends Person {
    private static final String INVALID_AGE_MORE_15_EXCEPTION_MESSAGE = "Child's age must be lesser than 15!";

    public Child(String name, int age){
        super(name, age);
    }

    protected void setAge(int age){
        if(age > 15)
            throw new IllegalArgumentException(this.INVALID_AGE_MORE_15_EXCEPTION_MESSAGE);
        super.setAge(age);
    }
}
