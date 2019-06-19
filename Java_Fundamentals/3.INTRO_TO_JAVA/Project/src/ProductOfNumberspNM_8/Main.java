package ProductOfNumberspNM_8;

//judge 100%

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
				
		int firstNumber = input.nextInt();
		int secondNumber = input.nextInt();
		
		
		BigInteger product = new BigInteger("1");
		
		for(int i = firstNumber; i <= secondNumber ; i++) {
			product = product.multiply(BigInteger.valueOf(i)); 
		}

		
		System.out.println(String.format("product[%d..%d] = %d", firstNumber, secondNumber, product));
		
		input.close();
	}
}
