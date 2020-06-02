package GenericSwapMethodStrings_03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class BoxesImpl<T> extends ArrayList implements Boxes<T> {

    private List<T> list;

    public BoxesImpl() {
        this.list = new ArrayList<>();
    }



    @Override
    public boolean addElement(T element) {
        return this.list.add(element);
    }

    @Override
    public void forEach() {
        this.list.forEach(System.out::println);
    }

    @Override
    public void swap(int firstPosition, int secondPosition) {
        T firstElement = list.get(firstPosition);
        this.list.set(firstPosition, this.list.get(secondPosition));
        this.list.set(secondPosition, firstElement);
    }
}
