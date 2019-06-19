package Numbers09_7;

//judge 100%

public class Main {
	
	private static final int LAST_NUMBER_TO_PRINT = 9;
	
	public static void main(String[] args) {
		
		int startIndex = 0;
		// + 1 to reach print -> 9
		while(startIndex != LAST_NUMBER_TO_PRINT + 1) {
			
			System.out.println(String.format("Number: %d", startIndex));
			
			startIndex++;
		}
		
	}
}
