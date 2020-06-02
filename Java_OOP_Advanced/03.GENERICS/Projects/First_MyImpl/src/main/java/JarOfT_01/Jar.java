package JarOfT_01;

import java.util.ArrayList;
import java.util.List;

public class Jar<T> {

    private List<T> jar;

    public Jar() {
        this.jar = new ArrayList<>();
    }

    public void add(T element){
        jar.add(element);
    }

    public T remove(){
        return jar.remove(jar.size() - 1);
    }
}
