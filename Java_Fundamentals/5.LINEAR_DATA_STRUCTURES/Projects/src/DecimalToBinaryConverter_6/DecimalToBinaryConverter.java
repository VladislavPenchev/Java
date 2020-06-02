package DecimalToBinaryConverter_6;

import java.util.ArrayDeque;
import java.util.Scanner;

//judge - 80

public class DecimalToBinaryConverter {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int number = Integer.parseInt(input.nextLine());
		
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		
		number = Math.abs(number);
		
		while(number != 0){
		
		stack.push(number % 2);
		
		number /= 2;
		}
		
		for(int digit : stack){
			System.out.print(digit);
		}
		
		
		input.close();
	}
}
