package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    private final static int INITIAL_CAPACITY = 4;

    private Object[] elements;
    private int size;
    private int capacity;


    public ArrayList() {
        this.elements = new Object[INITIAL_CAPACITY];
        this.size = 0;
        this.capacity = INITIAL_CAPACITY;
    }

    @Override
    public boolean add(E element) {
        if(this.size == this.capacity) {
            grow();
        }

        this.elements[size] = element;
        size++;

        return true;
    }

    @Override
    public boolean add(int index, E element) {
        checkIndexExists(index);

        shiftRight(index);

        this.elements[index] = element;
        this.size++;

        return true;
    }

    @Override
    public E get(int index) {
        checkIndexExists(index);

        return (E) this.elements[index];
    }

    @Override
    public E set(int index, E element) {
        checkIndexExists(index);

        Object previous = this.elements[index];

        this.elements[index] = element;

        return (E) previous;
    }

    @Override
    public E remove(int index) {
        checkIndexExists(index);

        Object previous = this.elements[index];

        shiftLeft(index);
        size--;
//        if(this.size < this.elements.length / 3) {
//            this.elements  =
//        }
        return (E) previous;
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.size - index; i++) {
            this.elements[i] = this.elements[i + 1];
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < this.size(); i++) {
            if(this.elements[i].equals(element)){
                return i;
            }
        }

        return -1;
    }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i <this.size; i++) {
            if(this.elements[i].equals(element)){
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.size <= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return this.index < size();
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }

    private void grow() {
        capacity *= 2;
        Object[] newArr = new Object[this.capacity];

        for (int i = 0; i <this.size(); i++) {
            newArr[i] = this.elements[i];
        }

        this.elements = newArr;
    }

    private void checkIndexExists(int index) {
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException(String.format("Indxe out of bounds: %d for size: %d", index, this.size));
        }
    }

    private void shiftRight(int index) {
        for (int i = this.size(); i > index; i--) {
            this.elements[i] = this.elements[i - 1];
        }
    }

}
