package EuroTrip_4;

import java.math.BigDecimal;
import java.util.Scanner;

//judge 100%

public class Main {
	
	private final static double PRICE_WURST_FOR_ONE_KG_IN_BG = 1.20; 
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double quantity = input.nextDouble();
		
		double pricePerQuantityBG =  quantity * PRICE_WURST_FOR_ONE_KG_IN_BG;
		
		//BigInteger priceInDMFromBG = new BigInteger("1");
		BigDecimal exchangeRateDmToBg = new BigDecimal("4210500000000");
		
		//exchange BG to DM
		BigDecimal priceInDMFromBG = new BigDecimal(pricePerQuantityBG);
		
		BigDecimal marksNeeded = exchangeRateDmToBg.multiply(priceInDMFromBG);
				
		
		System.out.println(String.format("%.2f marks", marksNeeded));
		
		
	}
}
