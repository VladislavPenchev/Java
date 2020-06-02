package GenericCountMethodStrings_fd_5;

public class Box<T extends Comparable<T>> implements Comparable<T> {

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

    @Override
    public int compareTo(T other) {
        return this.value.compareTo(other);
    }
}
