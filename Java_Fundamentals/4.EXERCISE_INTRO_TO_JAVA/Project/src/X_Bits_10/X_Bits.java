package X_Bits_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.*;

public class X_Bits {
	
	private static final int NUMBER_OF_BITS = 8;
	private static final String NULL = "0";
	
	public static void main(String[] args) {
		Scanner inputNumbers = new Scanner(System.in);
		
		int countOfNumber = 8;
		List<Integer> numbers = new ArrayList<>();
		Integer[][] matrix = new Integer[8][8];
		
		//read numbers
		while(countOfNumber-- != 0) {
			int line = Integer.parseInt(inputNumbers.nextLine());
			
			numbers.add(line);
		}
		
		//convert numbers to bin and add in matrix
		Map<Integer, List<Integer>> numbersToBinMap = convertNumberFromDecToBin(numbers);
		
		addNumbersToMatrix(numbersToBinMap, matrix);
		
		inputNumbers.close();
	}

	private static Map<Integer, List<Integer>> convertNumberFromDecToBin(List<Integer> numbers) {
		
		Map<Integer, List<Integer>> map = new HashMap();
		
		for(int number : numbers) {
			String binNumber = Integer.toBinaryString(number);
			
			//char[] numberToChars = binNumber.toCharArray();
			
			// can miss any bits from front
			String numberToCharsWithAllBits = "";
			
			if(binNumber.length() != NUMBER_OF_BITS) {
				
				String tempNulls = "";
				for(int i = 0; i < NUMBER_OF_BITS - binNumber.length(); i++) {
					tempNulls += NULL;
				}
				
				numberToCharsWithAllBits = String.format("%s%s", tempNulls, binNumber);
			}
			
			char[] numberToChars = numberToCharsWithAllBits.toCharArray();
			
			List<Integer> numberBits = new ArrayList<>();
			
			for(char numChar : numberToChars) {
				numberBits.add(Character.getNumericValue(numChar));								
			}
			
			map.putIfAbsent(number, numberBits);
			
			numberBits.clear();
		}
		return map;
	}
	
	private static void addNumbersToMatrix(Map<Integer, List<Integer>> numbers, Integer[][] matrix) {
				
		int row = 0;
		int col = 0;
		
		numbers.entrySet()
			.stream()
			.forEach(currentList -> {
				
				int tempCol = 0;
				int tempRow = 0;
				
				if(matrix[0][7] == 0 || matrix[0][7] == 1) {
					tempRow = 1;
				}
				
				for(int num : currentList.getValue()) {
					
					matrix[tempRow][tempCol] = num;
					tempCol++;
				}
				tempRow++;
				
			});
	}
	
}

