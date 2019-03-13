package Shape_fd_3;

public class Rectangel extends Shape{
    private double sideA;
    private double sideB;

    public Rectangel(double sideA, double sideB){
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public void calcPerimeter() {
        super.setPerimeter(this.sideA * 2 + this.sideB * 2);
    }

    @Override
    public void calculateArea() {
        super.setArea(this.sideA * this.sideB);
    }
}
