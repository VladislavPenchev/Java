package VehiclesExtensions_fd_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    private static final Map<String, Double> SUMMER_MODE_PERMANENT_ON = new HashMap<String, Double>() {{
        put("Car", 0.9);
        put("Truck", 1.6);
        put("Bus", 1.4);
    }};

    private static final String DRIVE_COMMAND = "Drive";
    private static final String REFUEL_COMMAND = "Refuel";
    private static final String DRIVE_EMPTY_COMMAND = "DriveEmpty";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carLine = reader.readLine().split("\\s+");

        String carType = carLine[0];
        double carFuelQuantity = Double.parseDouble(carLine[1]);
        double carLitersPerKm = Double.parseDouble(carLine[2]);
        double carTank = Double.parseDouble(carLine[3]);

        Vehicle car = new Car(carFuelQuantity,carLitersPerKm,carTank);

        String[] truckLine = reader.readLine().split("\\s+");

        String truckType = truckLine[0];
        double truckFuelQuantity = Double.parseDouble(truckLine[1]);
        double truckLitersPerKm = Double.parseDouble(truckLine[2]);
        double truckTank = Double.parseDouble(truckLine[3]);

        Vehicle truck = new Truck(truckFuelQuantity,truckLitersPerKm,truckTank);

        String[] busLine = reader.readLine().split("\\s+");

        String busType = busLine[0];
        double busFuelQuantity = Double.parseDouble(busLine[1]);
        double busLitersPerKm = Double.parseDouble(busLine[2]);
        double busTank = Double.parseDouble(busLine[3]);

        Vehicle bus = new Bus(truckFuelQuantity,truckLitersPerKm,busTank);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        vehicles.put(carType, car);
        vehicles.put(truckType,truck);
        vehicles.put(busType, bus);

        int countOfCommands = Integer.parseInt(reader.readLine());

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        while(countOfCommands-- > 0){
            String[] commandTokens = reader.readLine().split("\\s+");

            String command = commandTokens[0];
            String vehicleType = commandTokens[1];
            double parameter = Double.parseDouble(commandTokens[2]);

            switch(command){
                case DRIVE_COMMAND:
                    boolean isTravelld = vehicles.get(vehicleType).drive(parameter, SUMMER_MODE_PERMANENT_ON.get(vehicleType));
                    if(isTravelld){
                        System.out.println(String.format("%s travelled %s km", vehicleType,decimalFormat.format(parameter)));
                    }else{
                        System.out.println(String.format("%s refueling", vehicleType));
                    }
                    break;
                case REFUEL_COMMAND:
                    try{
                        vehicles.get(vehicleType).refuel(parameter);
                    }catch(IllegalArgumentException iae){
                        System.out.println(iae.getMessage());
                    }
                    break;
                case DRIVE_EMPTY_COMMAND:
                    isTravelld = vehicles.get(vehicleType).drive(parameter);
                    if(isTravelld){
                        System.out.println(String.format("%s travelled %s km", vehicleType,decimalFormat.format(parameter)));
                    }else{
                        System.out.println(String.format("%s refueling", vehicleType));
                    }
                    break;
            }
        }

        vehicles.values()
                .forEach(vehicle -> System.out.println(vehicle));



    }
}
