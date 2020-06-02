package P05_Square;

public class Main {
    public static void main(String[] args) {
        Square square = new Square();

        Rectangle rectangle = new Square();
        rectangle.setHeight(5);
        rectangle.setWidth(5);

        System.out.println(rectangle.getArea());
    }
}
