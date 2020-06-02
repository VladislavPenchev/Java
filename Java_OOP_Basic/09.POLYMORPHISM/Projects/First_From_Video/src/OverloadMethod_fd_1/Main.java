package OverloadMethod_fd_1;

public class Main {
    public static void main(String[] args) {
        MathOperation mathOperation = new MathOperation();

        System.out.println(mathOperation.sum(5,10));
    }
}

class MathOperation{
    public int sum(int a, int b){
        return a + b;
    }

    public int sum(int a, int b,int c){
        return a + b + c;
    }

    public int sum(int a,double c,  int b){
        return (int) (a + b + c);
    }
}
