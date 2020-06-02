package RectangleArea_1;
import java.util.Scanner;

//judge 40%

public class RectangleArea_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();

        double sum = 0;

        sum = firstNum * secondNum;
        System.out.println(String.format("%.2f",sum));
        
        scanner.close();
    }
}


