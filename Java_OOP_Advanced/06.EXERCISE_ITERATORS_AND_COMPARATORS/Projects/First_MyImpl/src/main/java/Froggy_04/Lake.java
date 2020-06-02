package Froggy_04;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Lake<T> implements Iterable<T> {

    private List<T> numbers;

    public Lake(List<T> numbers) {
        this.numbers = numbers;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

        for (T number: this) {
            action.accept(number);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<T> {

        private int cursor;
        private boolean isEven;

        public Frog() {
            this.cursor = 0;
            this.isEven = true;
        }

        @Override
        public boolean hasNext() {
            boolean hasNext = this.cursor < numbers.size();
            if(!this.isEven && !hasNext) {
                return false;
            } else if(this.isEven && !hasNext) {
                this.isEven = false;
                this.cursor = 1;
                return true;
            }
            return true;
        }

        @Override
        public T next() {
//            if(isEven && this.cursor > 0) {
//                this.cursor++;
//            } else if(!isEven && this.cursor > 1) {
//                this.cursor++;
//            }
            T t =  numbers.get(this.cursor);
            this.cursor += 2;
            return t;
        }
    }
}
