package AverageOfThreeNumbers_3;

import java.util.Scanner;

//judge 100%

public class Main {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); 
		
		double firstNumber = input.nextDouble();
		double secondNumber = input.nextDouble();
		double thirdNumber = input.nextDouble();
		
		double sum = (firstNumber + secondNumber + thirdNumber) / 3;
		
		System.out.println(String.format("%.2f", sum));
		
	}	
}
