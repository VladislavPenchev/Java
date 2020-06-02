package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    private final static int INITIAL_CAPACITY = 4;

    private Object[] elements;
    private int capacity;
    private int size;

    public ArrayList() {
        this.elements = new Object[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
        this.size = 0;
    }

    @Override
    public boolean add(E element) {
        if(this.capacity == this.size()){
            grow();
        }

        this.elements[size] = element;

        this.size++;

        return true;
    }

    @Override
    public boolean add(int index, E element) {
        if(validIndex(index)) {
            return false;
        }

        ShiftRight(index);

        this.elements[index] = element;

        this.size++;

        return true;
    }

    @Override
    public E get(int index) {
        checkIfIndexExists(index);

        return (E) this.elements[index];
    }

    @Override
    public E set(int index, E element) {
        checkIfIndexExists(index);

        E previously = (E) this.elements[index];

        ShiftRight(index);

        this.elements[index] = element;

        return previously;
    }

    @Override
    public E remove(int index) {
        checkIfIndexExists(index);

        Object removedElemet = this.elements[index];

        for (int i = index; i < this.size - 1; i++) {
            this.elements[i] = i + 1;
        }
        size--;

        shrinkIfNeeded();
        return (E) removedElemet;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int indexOf(E element) {
        if(this.contains(element)) {
            for (int i = 0; i < this.size; i++) {
                if(this.elements[i].equals(element)){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i < this.size; i++) {
            if(this.elements[i].equals(element)){
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return size > index;
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }

    private void grow() {
        this.capacity *= 2;
        Object[] newArr = new Object[this.capacity];

        for (int i = 0; i < this.elements.length; i++) {
            newArr[i] = this.elements[i];
        }

        this.elements = newArr;
    }

    private boolean validIndex(int index) {
        return index >= 0 || index < this.size;
    }

    private void checkIfIndexExists(int index) {
        if(!validIndex(index)){
            throw new IndexOutOfBoundsException(String.format("Index out of bounds: %d for size: %d", index, this.size));
        }
    }

    private void ShiftRight(int index) {
        for (int i = this.size - 1; i >= index ; i--) {
            this.elements[i + 1] = this.elements[i];
        }
    }

    private void shrinkIfNeeded() {
        if(this.size > this.capacity / 3){
            return;
        }

        this.capacity /= 2;
        this.elements = Arrays.copyOf(this.elements, this.capacity);

    }
}
