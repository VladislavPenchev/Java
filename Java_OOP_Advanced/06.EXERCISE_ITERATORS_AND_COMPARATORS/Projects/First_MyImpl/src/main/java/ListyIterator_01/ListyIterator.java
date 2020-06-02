package ListyIterator_01;

import java.util.Collections;

public class ListyIterator<T> {
    private T[] items;
    private int index;

    public ListyIterator(T... args) {
        this.items = args;
    }

    public boolean move() {
        if(hasNext()){
            index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.index < this.items.length - 1;
    }

    public void print() {
        if(items != null && items.length > 0) {
            System.out.println(items[index]);
        }
    }
}
