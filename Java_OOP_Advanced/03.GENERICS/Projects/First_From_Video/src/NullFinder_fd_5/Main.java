package NullFinder_fd_5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<?> list;

        List<String> numbers = new ArrayList(){{
            add(null); add("dasda"); add(null);
        }};

        System.out.println(ListUtils.getNullIndeces(numbers));
    }
}
