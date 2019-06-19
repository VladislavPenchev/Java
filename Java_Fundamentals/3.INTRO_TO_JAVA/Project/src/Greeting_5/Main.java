package Greeting_5;

import java.util.Scanner;

//judge 60%

public class Main {
	
	private static final String IF_FIRSTNAME_IS_EMPTY = "*****";
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String firstName = input.nextLine();
		String lastName = input.nextLine();
		
		if(!firstName.isEmpty()) {
			System.out.println(String.format("Hello, %s %s!", firstName, lastName));
		}else {
			System.out.println(String.format("Hello, %s %s!", IF_FIRSTNAME_IS_EMPTY, lastName));
		}
	
		input.close();
	}
}


