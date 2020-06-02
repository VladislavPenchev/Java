package FragileBaseClass_04;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Predator predator = new Predator();

        List<Food> food = new ArrayList<>(){{
            add(new Food());
            add(new Food());
            add(new Food());
            add(new Food());
        }};

    }
}
