package TransportPrice_6;

import java.util.Scanner;

//judge 100%

public class Main {
	
	private static final double TAXI_INITIAL_TAX_USD = 0.70;
	private static final double TAXI_DAY_TIME_COST_USD_KM = 0.79;
	private static final double TAXI_NIGHT_TIME_COST_USD_KM = 0.90;
	
	private static final double BUS_DAY_NIGHT_TARIFF_USD_KM = 0.09;
	private static final double TRAIN_DAY_NIGHT_TARIFF_USD_KM = 0.06;
	
	private static final String DAY = "day";
	//private static final String NIGHT = "night";
	
	
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int duration = Integer.parseInt(input.nextLine());
		String TimeOfDayOrDay = input.nextLine();
		
		double sum = 0.0;
		
		if(duration < 20) {
			if(TimeOfDayOrDay.equals(DAY)) {
				sum = TAXI_INITIAL_TAX_USD + (TAXI_DAY_TIME_COST_USD_KM * duration);
			}else {
				sum = TAXI_INITIAL_TAX_USD + (TAXI_NIGHT_TIME_COST_USD_KM * duration);
			}			
		}else if(duration < 100) {
			
			sum = BUS_DAY_NIGHT_TARIFF_USD_KM * duration;
					
		}else {
			sum = TRAIN_DAY_NIGHT_TARIFF_USD_KM * duration;
		}
		
		
		System.out.println(String.format("%.2f", sum));
		
		input.close();
		
	}
}
