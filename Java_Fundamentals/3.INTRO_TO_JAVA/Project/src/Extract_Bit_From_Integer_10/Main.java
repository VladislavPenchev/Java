package Extract_Bit_From_Integer_10;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int num = input.nextInt();
		int bitPos = input.nextInt();
		
		int mask = num >> bitPos;
		int result = 1 & mask;
		
		System.out.println(result);
		
		input.close();
	}
}
