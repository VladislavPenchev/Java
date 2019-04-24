package GenericFlatMethod_fd_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> ints = new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }};


        List<Double> doubles = new ArrayList<>();

        Collections.addAll(doubles, 5.5, 6.7);

        List<List<? extends  Number>> jagged = new ArrayList<>();
        Collections.addAll(jagged, ints, doubles);

        List<Number> dest = new ArrayList<>();

        ListUtils.flatten(dest, jagged);
        System.out.println(dest);
    }
}
