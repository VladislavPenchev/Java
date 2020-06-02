package VehicleExtension_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    private static final Map<String, Double> SUMMER_HOME_PERMANENT_ON = new HashMap() {{
        put("Car", 0.9);
        put("Truck", 1.6);
        put("Bus", 1.4);
    }};

    private static final String DRIVE_COMMAND = "Drive";
    private static final String DRIVE_EMPTY_BUS_COMMAND = "DriveEmpty";
    private static final String REFUEL_COMMAND = "Refuel";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] carArgs = bufferedReader.readLine().split("\\s+");
        Double fuelQuantityCar = Double.parseDouble(carArgs[1]);
        Double litersPerKmCar = Double.parseDouble(carArgs[2]);
        Double tankCapacityCar = Double.parseDouble(carArgs[3]);
        Vehicle car = new Car(fuelQuantityCar, litersPerKmCar, tankCapacityCar);

        String[] truckArgs = bufferedReader.readLine().split("\\s+");
        Double fuelQuantityTruck = Double.parseDouble(truckArgs[1]);
        Double litersPerKmTruck = Double.parseDouble(truckArgs[2]);
        Double tankCapacityTruck = Double.parseDouble(truckArgs[3]);
        Vehicle truck = new Truck(fuelQuantityTruck, litersPerKmTruck, tankCapacityTruck);

        String[] busArgs = bufferedReader.readLine().split("\\s+");
        Double fuelQuantityBus = Double.parseDouble(busArgs[1]);
        Double litersPerKmBus = Double.parseDouble(busArgs[2]);
        Double tankCapacityBus = Double.parseDouble(busArgs[3]);
        Vehicle bus = new Bus(fuelQuantityBus, litersPerKmBus, tankCapacityBus);

        Map<String, Vehicle> vehicles = new LinkedHashMap<String, Vehicle>();
        vehicles.put(carArgs[0], car);
        vehicles.put(truckArgs[0], truck);
        vehicles.put(busArgs[0], bus);

        int countOfCommands = Integer.parseInt(bufferedReader.readLine());

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        for (int i = 0; i < countOfCommands; i++) {

            String[] commandArgs = bufferedReader.readLine().split("\\s+");
            String command = commandArgs[0];
            String vehicleType = commandArgs[1];
            double parameter = Double.parseDouble(commandArgs[2]);

            if(DRIVE_COMMAND.equals(command)){
                boolean isTravelled = vehicles.get(vehicleType).drive(parameter, SUMMER_HOME_PERMANENT_ON.get(vehicleType));
                if(isTravelled) {
                    System.out.println(String
                            .format("%s travelled %s km",vehicleType, decimalFormat.format(parameter)));
                }else {
                    System.out.println(String
                            .format("%s needs refueling",vehicleType));
                }
            }else if(REFUEL_COMMAND.equals(command)){
                try{
                    vehicles.get(vehicleType).refuel(parameter);
                }catch (IllegalArgumentException iae){
                    iae.getMessage();
                }
            }
            else if(DRIVE_EMPTY_BUS_COMMAND.equals(command)){
                try{
                    vehicles.get(vehicleType).refuel(parameter);
                }catch (IllegalArgumentException iae){
                    iae.getMessage();
                }
            }
        }
        vehicles.values().forEach(System.out::println);
    }
}
