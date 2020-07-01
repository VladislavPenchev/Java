package GenericBoxOfInteger_fd_2;

public class Box<T> {

    private T value;

    public Box(){

    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.value.getClass().getName(), this.value);
    }
}