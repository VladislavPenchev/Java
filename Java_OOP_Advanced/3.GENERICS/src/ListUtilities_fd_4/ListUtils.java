package ListUtilities_fd_4;

import java.util.List;

public class ListUtils<T> {

    public static <T extends Comparable> T getMin(List<T> list){
        if(list.isEmpty()){
            throw new IllegalArgumentException("Empty list!");
        }

        T min = list.get(0);

        for (T t : list) {
            if(t.compareTo(min) < 0){
                min = t;
            }
        }

        return min;
    }


    public static <T extends Comparable> T getMax(List<T> list){
        if(list.isEmpty()){
            throw new IllegalArgumentException("Empty list!");
        }

        T min = list.get(0);

        for (T t : list) {
            if(t.compareTo(min) > 0){
                min = t;
            }
        }

        return min;
    }

}
