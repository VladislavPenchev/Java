package Shape_fd_3;

public abstract class Shape {
    private double perimeter;
    private double area;

    public double getPerimeter(){
        return this.perimeter;
    };


    public double getArea() {
        return this.area;
    }

    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    protected void setArea(double area) {
        this.area = area;
    }

    public abstract void calcPerimeter();

    public abstract  void calculateArea();
}
