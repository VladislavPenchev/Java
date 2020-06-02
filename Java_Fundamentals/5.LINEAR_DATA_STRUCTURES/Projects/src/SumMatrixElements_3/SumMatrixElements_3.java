package SumMatrixElements_3;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
// judge - 100%

public class SumMatrixElements_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> dimensions = Arrays.stream(scanner.nextLine().split(", "))
                                .collect(Collectors.toList());

        int rows = Integer.parseInt(dimensions.get(0));
        int cols = Integer.parseInt(dimensions.get(1));

        int[][] matrix = new int[rows][cols];

        for(int row = 0; row < matrix.length; row++){
            String[] values = scanner.nextLine().split(", ");

            for(int col = 0; col < matrix[row].length; col++){
                matrix[row][col] = Integer.parseInt(values[col]);
            }
        }

        int sum = 0;
        for(int[] row : matrix){
            for(int col : row){
                sum +=col;
            }
        }
        
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
