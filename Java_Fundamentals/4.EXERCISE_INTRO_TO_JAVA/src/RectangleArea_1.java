import java.util.Scanner;

public class RectangleArea_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();
        scanner.nextLine();

        int sum = 0;

        sum = firstNum * secondNum;
        System.out.printf("%d.00",sum);
    }
}


