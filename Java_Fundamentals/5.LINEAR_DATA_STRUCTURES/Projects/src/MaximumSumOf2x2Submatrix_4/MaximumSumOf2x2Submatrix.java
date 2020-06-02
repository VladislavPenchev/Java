package MaximumSumOf2x2Submatrix_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//judge 100%

public class MaximumSumOf2x2Submatrix {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String[] dimensions = input.nextLine().split(", ");
		
		int countOfRows = Integer.parseInt(dimensions[0]);
		int countOfCols = Integer.parseInt(dimensions[1]);
		
		int[][] matrix = createMatrix(input, countOfRows, countOfCols);
		
		//return list with three parameters {biggestSum, rowIndex, colIndex}
		List<Integer> params = biggestSum(matrix);
		
		int biggestSum = params.get(0);
		int rowIndex = params.get(1);
		int colIndex = params.get(2);
		
		print(biggestSum, rowIndex, colIndex, matrix);
		
		
		input.close();
	}
	
	private static int[][] createMatrix(Scanner input ,int countOfRows, int countOfCols) {
				
		int matrix[][] = new int [countOfRows][countOfCols];
		
		for(int row = 0; row < matrix.length; row++) {
			String[] lineValues = input.nextLine().split(", ");
			
			for(int col = 0; col < matrix[row].length; col++) {
				matrix[row][col] = Integer.parseInt(lineValues[col]);
			}
		}
		return matrix;
	}
	
	private static List<Integer> biggestSum(int[][] matrix) {
		
		List<Integer> params = new ArrayList<>();
		
		int rowIndex = 0;
		int colIndex = 0;
		
		int biggestSum = Integer.MIN_VALUE;
		
		for(int row = 0; row < matrix.length - 1; row++) {
			for(int col = 0; col < matrix[row].length - 1; col++) {
								
				int sum = matrix[row][col] +
					  matrix[row][col + 1] +
					  matrix[row + 1][col] +
					  matrix[row + 1][col + 1];
				
				if(sum > biggestSum) {
					biggestSum = sum;
					rowIndex = row;
					colIndex = col;
				}
			}
		}
		
		params.add(biggestSum);
		params.add(rowIndex);
		params.add(colIndex);
		
		return params;
	}
	
	private static void print(int biggestSum, int rowIndex, int colIndex, int[][] matrix) {
		System.out.println(String.format("%s %s", matrix[rowIndex][colIndex], matrix[rowIndex][colIndex + 1]));
		System.out.println(String.format("%s %s", matrix[rowIndex + 1][colIndex], matrix[rowIndex + 1][colIndex + 1]));
		System.out.println(biggestSum);
	}
	
}
