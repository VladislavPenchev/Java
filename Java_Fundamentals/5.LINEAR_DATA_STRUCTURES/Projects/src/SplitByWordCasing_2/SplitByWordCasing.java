package SplitByWordCasing_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Judge 25%
public class SplitByWordCasing {
	
	public static void main(String[] args) {
		run();
	}
	
	private static void run() {
		
		Scanner input = new Scanner(System.in);
		
		String[] text = input.nextLine().split("[.!,/()'\\\\\";:\\[\\] ]");
		
		List<String> lowerCaseWords = new ArrayList<>();
		List<String> upperCaseWords = new ArrayList<>();
		List<String> mixedCaseWords = new ArrayList<>();
		
	
		for(String word : text) {
			char[] wordLetters = word.toCharArray();
			
			String temp = "";
			
			for(char wlet : wordLetters) {
				if(Character.isUpperCase(wlet)) {
					temp += "X";
				} else if(Character.isLowerCase(wlet)) {
					temp += "x";
				}else if (Character.isDigit(wlet)) {
					temp += 1;
				}else if(wlet == '#') {
					temp += "#";
				}
			}
			
			if(temp.contains("x") && temp.contains("X") || temp.contains("#") || temp.contains("1")) {
				mixedCaseWords.add(word);
			}else if(temp.contains("x") && !temp.contains("X")) {
				lowerCaseWords.add(word);
			}else if(temp.contains("X") && !temp.contains("x")){
				upperCaseWords.add(word);
			}
			
			temp = "";
			
		}
		
		
		print(lowerCaseWords, "Lower-case");
		print(mixedCaseWords, "Mixed-case");
		print(upperCaseWords, "Upper-case");
		
		input.close();
	}
	
	private static void print(List<String> words, String caseString) {
			String result = String.format("%s: %s", caseString,String.join(", ", words));
			
			System.out.println(result);
	}

}
