package GenericCountMethodStrings_05;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>>{

    private T line;

    public Box(T line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.line.getClass().getName(), this.line);
    }

    @Override
    public int compareTo(Box<T> other) {
        return this.line.compareTo(other.line);
    }
}
