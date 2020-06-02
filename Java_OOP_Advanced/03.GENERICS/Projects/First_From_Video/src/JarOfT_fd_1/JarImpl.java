package JarOfT_fd_1;

import java.util.ArrayDeque;

public class JarImpl<T> implements Jar<T>{

    private ArrayDeque<T> items;

    public JarImpl(){
        this.items = new ArrayDeque<T>();
    }

    @Override
    public void add(T element){
        this.items.push(element);
    }

    @Override
    public T remove(){
        if(this.items.size() > 0){
            return this.items.pop();
        }

        return null;
    }
}
