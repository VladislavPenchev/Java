package Lottery_9;
//judge 100%

public class Main {
	public static void main(String[] args) {
		
		for(int i = 1; i <= 8; i++) {
			for(int j = 1 + i; j <= 9; j++) {
				for(int k = 1 + j; k <= 10; k++) {
					System.out.print(String.format("%d %d %d",i, j, k));
					System.out.println();
				}
			}
		}
		
	}
}
