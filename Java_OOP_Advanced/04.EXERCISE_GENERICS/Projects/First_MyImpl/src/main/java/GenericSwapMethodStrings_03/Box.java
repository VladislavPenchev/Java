package GenericSwapMethodStrings_03;

public class Box<T> {

    private T line;

    public Box(T line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.line.getClass().getName(), this.line);
    }
}
