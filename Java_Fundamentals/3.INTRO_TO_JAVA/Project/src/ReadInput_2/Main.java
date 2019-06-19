package ReadInput_2;
import java.util.Scanner;

//judge 80%

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String firstWord = input.next("\\w+");
		String secondWord = input.next("\\w+");
		
		
		int firstNumber = input.nextInt();
		int secondNumber = input.nextInt();
		int thirdNumber = input.nextInt();
		
		int sum = firstNumber + secondNumber + thirdNumber;
		
		input.hasNextLine();
		
		String lastWord = input.next("\\w+");
		
		System.out.println(String.format("%s %s %s %d", firstWord, secondWord, lastWord, sum));
		
		input.close();
	}
}


