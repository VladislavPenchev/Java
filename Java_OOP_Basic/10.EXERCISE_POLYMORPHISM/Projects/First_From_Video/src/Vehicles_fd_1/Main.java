package Vehicles_fd_1;

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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carLine = reader.readLine().split("\\s+");

        String carType = carLine[0];
        double carFuelQuantity = Double.parseDouble(carLine[1]);
        double carLitersPerKm = Double.parseDouble(carLine[2]);

        Vehicle car = new Car(carFuelQuantity,carLitersPerKm);

        String[] truckLine = reader.readLine().split("\\s+");

        String truckType = truckLine[0];
        double truckFuelQuantity = Double.parseDouble(truckLine[1]);
        double truckLitersPerKm = Double.parseDouble(truckLine[2]);

        Vehicle truck = new Truck(truckFuelQuantity,truckLitersPerKm);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        vehicles.put(carType, car);
        vehicles.put(truckType,truck);

        int countOfCommands = Integer.parseInt(reader.readLine());

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        while(countOfCommands-- > 0){
            String[] commandTokens = reader.readLine().split("\\s+");

            String command = commandTokens[0];
            String vehicleType = commandTokens[1];
            double parameter = Double.parseDouble(commandTokens[2]);

            switch(command){
                case DRIVE_COMMAND:
                    boolean isTravelld = vehicles.get(vehicleType).drive(parameter);
                    if(isTravelld){
                        System.out.println(String.format("%s travelled %s km", vehicleType,decimalFormat.format(parameter)));
                    }else{
                        System.out.println(String.format("%s refueling", vehicleType));
                    }
                    break;
                case REFUEL_COMMAND:
                    vehicles.get(vehicleType).refuel(parameter);
                    break;
            }
        }

        vehicles.values()
                .forEach(vehicle -> System.out.println(vehicle));



    }
}
