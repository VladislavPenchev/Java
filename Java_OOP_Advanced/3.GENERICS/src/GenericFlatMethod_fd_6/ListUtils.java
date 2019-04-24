package GenericFlatMethod_fd_6;

import java.util.ArrayList;
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

    public static List<Integer> getNullIndeces(List<?> list ){
        List<Integer> indeces = new ArrayList<>();

        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == null){
                indeces.add(i);
            }
        }

        return indeces;
    }

    public static <T> void flatten (List<? super T> dest, List<List<? extends T >> src){
        for (List list : src) {
            dest.addAll(list);
        }
    }

    public static <T> void addAll (List<? super T> dest, List<? extends T> src){
        dest.addAll(src);
    }

}