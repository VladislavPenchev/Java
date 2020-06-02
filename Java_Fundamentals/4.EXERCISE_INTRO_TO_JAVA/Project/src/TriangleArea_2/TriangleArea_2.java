package TriangleArea_2;
import java.util.Scanner;

public class TriangleArea_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ax = scanner.nextInt();
        int ay = scanner.nextInt();

        int bx = scanner.nextInt();
        int by = scanner.nextInt();

        int cx = scanner.nextInt();
        int cy = scanner.nextInt();

        int area;
        area = ((ax*(by - cy)) + (bx*(cy - ay)) + (cx*(ay - by)))/2;

        System.out.println(Math.abs((area)));
    }
}
