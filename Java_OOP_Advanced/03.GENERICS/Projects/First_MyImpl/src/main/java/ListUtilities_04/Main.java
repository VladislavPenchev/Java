package ListUtilities_04;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers,1, 2, 18, 2 , -1);

        Integer maxInteger = ListUtils.getMax(integers);
        Integer minInteger = ListUtils.getMin(integers);

        System.out.println(maxInteger);
        System.out.println(minInteger);
    }
}
