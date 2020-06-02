package MethodOverriding_fd_2;

public class Rectangle {
    private double sideA;
    private double sideB;

    protected Rectangle (double sideA){
        this.sideA = sideA;
    }

    public Rectangle(double sideA, double sideB){
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double getSideA() {
        return this.sideA;
    }

    public double area(){
        return this.sideA * this.sideB;
    }
}
