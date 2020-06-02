package GenericSwapMethodIntegers_04;

public interface Boxes<T> {

    boolean addElement(T element);

    void forEach();

    void swap(int firstPosition, int secondPosition);
}
