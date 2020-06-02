package Mankind_fd_3;

public class Human {
    private static final String INVALID_FIRSTNAME_CAPITAL_LETTER_EXCEPTION_MESSAGE = "Expected upper case letter!Argument: firstName";
    private static final String INVALID_FIRSTNAME_MORE_4_SYMBOLS_EXCEPTION_MESSAGE = "Expected length at least 4 symbols!Argument: firstName";
    private static final String INVALID_LASTNAME_CAPITAL_LETTER_EXCEPTION_MESSAGE = "Expected length at least 4 symbols!Argument: firstName";
    private static final String INVALID_LASTNAME_MORE_3_SYMBOLS_EXCEPTION_MESSAGE = "Expected length at least 3 symbols!Argument: lastName";

    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    private String getFirstName() {
        return this.firstName;
    }

    private void setFirstName(String firstName) {
        if(!firstName.substring(0,1).equals(firstName.substring(0,1).toUpperCase()))
            throw new IllegalArgumentException(this.INVALID_FIRSTNAME_CAPITAL_LETTER_EXCEPTION_MESSAGE);

        if(firstName.length() < 4)
            throw new IllegalArgumentException(this.INVALID_FIRSTNAME_MORE_4_SYMBOLS_EXCEPTION_MESSAGE);

        this.firstName = firstName;
    }

    private String getLastName() {
        return this.lastName;
    }

    protected void setLastName(String lastName) {
        if(!lastName.substring(0,1).equals(lastName.substring(0,1).toUpperCase()))
            throw new IllegalArgumentException(this.INVALID_LASTNAME_CAPITAL_LETTER_EXCEPTION_MESSAGE);

        if(firstName.length() < 3)
            throw new IllegalArgumentException(this.INVALID_LASTNAME_MORE_3_SYMBOLS_EXCEPTION_MESSAGE);

        this.lastName = lastName;
    }

    @Override
    public String toString() {

        StringBuilder human = new StringBuilder();

        human.append(String.format("First Name: %s", this.getFirstName()))
                .append(System.lineSeparator())
                .append(String.format("Last Name: %s", this.getLastName()))
                .append(System.lineSeparator());

        return human.toString();
    }
}
