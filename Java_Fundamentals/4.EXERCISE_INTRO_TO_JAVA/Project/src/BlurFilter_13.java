import java.util.Scanner;

public class BlurFilter_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberToIncrease = scanner.nextInt();

        int rows = scanner.nextInt();
        String rubbish = scanner.next();
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        for(int i = 0; i <= rows;i++){
            for(int j = 0; j <= cols; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }

        String[] cordinates = scanner.nextLine().split("");

        for(int i = 0; i <= rows;i++){
            for(int j = 0; j <= cols; j++){
                //System.out.printf(matrix[i][j] + " ");
            }
        }




    }
}
