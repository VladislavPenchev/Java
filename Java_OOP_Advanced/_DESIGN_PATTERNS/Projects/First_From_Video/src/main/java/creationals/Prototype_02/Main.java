package creationals.Prototype_02;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Circle firstCircle = new Circle("GREEN", new ArrayList<>(List.of("GREAT Success!")));

        Circle secondCircle = (Circle) firstCircle.clone();
        secondCircle.getText().add("I am second object");

        draw(firstCircle);
        draw(secondCircle);
    }

    public static void draw(ShapePrototype shapePrototype) {
        System.out.println(shapePrototype.toString());
    }
}
