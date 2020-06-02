package Shape_fd_3;

public class Circle extends Shape{

    private double radius;

    public Circle(double r){
        this.radius = r;
    }

    @Override
    public void calcPerimeter() {
        super.setPerimeter( 2 * Math.PI * this.radius);
    }

    @Override
    public void calculateArea() {
        super.setArea(Math.PI * this.radius * this.radius);
    }
}
