package Shape_fd_3;

public class Main {
    public static void main(String[] args) {

        Shape circle = new Circle(2.45);
        Shape rect = new Rectangel(5,10);

        circle.calcPerimeter();
        System.out.println(circle.getPerimeter());
        rect.calcPerimeter();
        System.out.println(rect.getPerimeter());

        circle.calculateArea();
        System.out.println(circle.getArea());
        rect.calculateArea();
        System.out.println(rect.getArea());
    }
}
