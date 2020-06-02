package ByteParty_9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ByteParty_9 {
	
	private static final String END = "party over";
	private static final int COUNT_OF_BINARY_NUMBER = 8;
	private static final char CHAR_NULL = '0';
	private static final char CHAR_ONE = '1';
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int countOfNumbers = Integer.parseInt(input.nextLine());
		List<Integer> numbers = new ArrayList<>();
			
		while(countOfNumbers-- != 0) {
			int currentNumber = Integer.parseInt(input.nextLine());
			numbers.add(currentNumber);
		}
		
		String lineWithCommands = "";
		while(!END.equals(lineWithCommands = input.nextLine())) {
			
			String[] lineArgs = lineWithCommands.split("\\s+");
			
			int command = Integer.parseInt(lineArgs[0]);
			int digitForPosititon = Integer.parseInt(lineArgs[1]);
			
			numbers.forEach(x -> {
				String numberToBinary = DecToBinAndCheck8Bits(x);
								
				String result = CommandDispacher(command, digitForPosititon, numberToBinary);
				
				int newNumber = Integer.parseInt(result, 2);
				
				System.out.println(newNumber);

			});
		}
		
		
		input.close();
	}
	
	private static String CommandDispacher(int command, int digitForPosititon, String number) {
				
		char charAtPosition = number.charAt(digitForPosititon);
		String result = "";
		
		switch(command) {
			case -1 : 
				//flip
				if(CHAR_NULL == charAtPosition) {
					result = SwapBits(number, digitForPosititon, CHAR_ONE);
				}else {
					result =  SwapBits(number, digitForPosititon, CHAR_NULL);
				}
				
			case 0 : result = SwapBits(number, digitForPosititon, CHAR_NULL);
			
			case 1 : result = SwapBits(number, digitForPosititon, CHAR_ONE);	
				
		}
		return result;
		
	}
	
	private static String SwapBits(String number, int digitForPosititon , char swapBitValue) {
		
		
		StringBuilder result = new StringBuilder(number);
		
		char charAtPosition = swapBitValue;
		
		result.setCharAt(digitForPosititon, charAtPosition);
		
		return result.toString();
	}
	
	private static String DecToBinAndCheck8Bits(int number) {
		String binaryNumber = Integer.toBinaryString(number);
		
		
		if(COUNT_OF_BINARY_NUMBER == binaryNumber.length()) {
			return binaryNumber;
		}else { 
			
			int numberOfNeededNulls = COUNT_OF_BINARY_NUMBER - binaryNumber.length();
			
			String neededNulls = "";
			while(numberOfNeededNulls != 0) {
				neededNulls += 0;
				
				numberOfNeededNulls--;
			}
			
			String withEightBits = neededNulls + binaryNumber;
			
			return withEightBits;
		}
		
	}
	
}
