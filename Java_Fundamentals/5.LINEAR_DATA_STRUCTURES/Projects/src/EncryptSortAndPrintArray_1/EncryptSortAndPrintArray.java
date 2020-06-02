package EncryptSortAndPrintArray_1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
//Judge - 80%
public class EncryptSortAndPrintArray {
	 public final static char[] VOWELS = {'a','A','e','E','i','I','o','O','u','U'};
	
	public static void main(String[] args) {
		
		run();
	}
	
	private static void run() {
		Scanner input = new Scanner(System.in);
		
		int countOfPeople = Integer.parseInt(input.nextLine());
		
		Map<String, Integer> peopleScores = new LinkedHashMap();
		
		while(countOfPeople-- != 0) {
			
			String person = input.nextLine();
			
			char[] personToCharArray = person.toCharArray();
			
			int sumOfCurrentPerson = 0;
			
			for(char per : personToCharArray) {
				
				int charValue = (int) per;
				
				if(isVowels(per)) {
					
					sumOfCurrentPerson += charValue * person.length();
				}else {
					sumOfCurrentPerson += charValue / person.length();
				}
			}
			
			peopleScores.putIfAbsent(person, sumOfCurrentPerson);
		}
		
		print(peopleScores);
		
		input.close();
	}
	
	private static boolean isVowels(char letter) {
		
		for(char curLet : VOWELS) {
			if(curLet == letter) {
				return true;
			}
		}		
		
		return false;
	}
	
	private static void print(Map<String, Integer> peopleScores) {
		
		peopleScores.entrySet()
			.stream()
			.sorted((sc1, sc2) -> sc1.getValue().compareTo(sc2.getValue()))
			.forEach(perKvp -> System.out.println(perKvp.getValue()));
	}
}
