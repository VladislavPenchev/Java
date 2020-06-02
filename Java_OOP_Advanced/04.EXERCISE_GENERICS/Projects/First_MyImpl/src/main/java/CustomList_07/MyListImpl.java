package CustomList_07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyListImpl<T extends Comparable<T>> implements MyList<T> {

    private List<T> elements;

    public MyListImpl() {
        this.elements = new ArrayList<>();
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < this.elements.size();
    }

    @Override
    public void add(T element) {
        elements.add(element);
    }

    @Override
    public T remove(int index) {
        if(isValidIndex(index)){
            return elements.remove(index);
        }
        return null;
    }

    @Override
    public boolean contains(T element) {
        return elements.contains(element);
    }

    @Override
    public void swap(int firstIndex, int secondIndex) {
        if(this.isValidIndex(firstIndex) && this.isValidIndex(secondIndex)){
            T firstElement = elements.get(firstIndex);
            elements.set(firstIndex, elements.get(secondIndex));
            elements.set(secondIndex, firstElement);
        }
    }

    @Override
    public int countGreaterThan(T element) {
        return (int) this.elements.stream()
                .filter(e -> e.compareTo(element) > 0)
                .count();
    }

    @Override
    public T getMax() {
        return elements.stream()
                .max(Comparator.naturalOrder())
                .get();
    }

    @Override
    public T getMin() {
        return elements.stream()
                .min(Comparator.naturalOrder())
                .get();
    }

    public Iterable<T> getElements() {
        return this.elements;
    }
}
