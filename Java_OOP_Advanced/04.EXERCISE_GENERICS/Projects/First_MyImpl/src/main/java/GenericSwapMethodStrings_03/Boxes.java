package GenericSwapMethodStrings_03;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public interface Boxes<T> {

    boolean addElement(T element);

    void forEach();

    void swap(int firstPosition, int secondPosition);
}
