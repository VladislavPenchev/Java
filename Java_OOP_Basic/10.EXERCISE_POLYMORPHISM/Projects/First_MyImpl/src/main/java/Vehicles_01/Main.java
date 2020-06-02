package Vehicles_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    private static final String DRIVE_COMMAND = "Drive";
    private static final String REFUEL_COMMAND = "Refuel";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] carArgs = bufferedReader.readLine().split("\\s+");
        Double fuelQuantityCar = Double.parseDouble(carArgs[1]);
        Double litersPerKmCar = Double.parseDouble(carArgs[2]);
        Vehicle car = new Car(fuelQuantityCar, litersPerKmCar);

        String[] truckArgs = bufferedReader.readLine().split("\\s+");
        Double fuelQuantityTruck = Double.parseDouble(truckArgs[1]);
        Double litersPerKmTruck = Double.parseDouble(truckArgs[2]);
        Vehicle truck = new Truck(fuelQuantityTruck, litersPerKmTruck);

        Map<String, Vehicle> vehicles = new LinkedHashMap<String, Vehicle>();
        vehicles.put(carArgs[0], car);
        vehicles.put(truckArgs[0], truck);


        int countOfCommands = Integer.parseInt(bufferedReader.readLine());

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        for (int i = 0; i < countOfCommands; i++) {

            String[] commandArgs = bufferedReader.readLine().split("\\s+");
            String command = commandArgs[0];
            String vehicleType = commandArgs[1];
            double parameter = Double.parseDouble(commandArgs[2]);

            if(DRIVE_COMMAND.equals(command)){
                boolean isTravelled = vehicles.get(vehicleType).drive(parameter);
                if(isTravelled) {
                    System.out.println(String
                            .format("%s travelled %s km",vehicleType, decimalFormat.format(parameter)));
                }else {
                    System.out.println(String
                            .format("%s needs refueling",vehicleType));
                }
            }else if(REFUEL_COMMAND.equals(command)){
                    vehicles.get(vehicleType).refuel(parameter);
            }
        }
        vehicles.values().forEach(System.out::println);
    }
}
