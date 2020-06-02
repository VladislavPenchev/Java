package Froggy_fd_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Lake<T> implements Iterable<T> {

    private List<T> numbers;

    public Lake(T... numbers) {
        this.numbers = new ArrayList<>();
    }

    @Override
    public Iterator<T> iterator() {
        return new Frog();
    }

    @Override
    public void forEach(Consumer<? super T> action) {


        for (T number : this) {
            action.accept(number);
        }
    }

    private final class Frog implements  Iterator<T>{

        private int cursor;
        private boolean isEven;

        public Frog() {
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {

            boolean hasNext = this.cursor < numbers.size();

            if(!this.isEven && !hasNext){
                return false;
            }
            return hasNext;
        }

        @Override
        public T next() {

            if(isEven){

            }else if(!isEven) {

            }

            return numbers.get(this.cursor++);
        }
    }
}
