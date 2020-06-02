package RawData_fd_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//TODO:  80% I think it's because of the order of sorting

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Car> cars = new ArrayList<>();

        int countOfCars = Integer.parseInt(reader.readLine());

        String[] line;
        for(int i = 0; i < countOfCars; i++){
            line = reader.readLine().split("\\s+");

            String model = line[0];

            int engineSpeed = Integer.parseInt(line[1]);
            int enginePower = Integer.parseInt(line[2]);

            int cargoWeight = Integer.parseInt(line[3]);
            String cargoType = line[4];

            double tire1pressure = Double.parseDouble(line[5]);
            int tire1Age = Integer.parseInt(line[6]);

            double tire2pressure = Double.parseDouble(line[7]);
            int tire2Age = Integer.parseInt(line[8]);

            double tire3pressure = Double.parseDouble(line[9]);
            int tire3Age = Integer.parseInt(line[10]);

            double tire4pressure = Double.parseDouble(line[11]);
            int tire4Age = Integer.parseInt(line[12]);

            Engine eng = new Engine(engineSpeed,enginePower);

            Cargo cargo = new Cargo(cargoType,cargoWeight);

            Tier tier1 = new Tier(tire1pressure,tire1Age);
            Tier tier2 = new Tier(tire2pressure,tire2Age);
            Tier tier3 = new Tier(tire3pressure,tire3Age);
            Tier tier4 = new Tier(tire4pressure,tire4Age);

            List<Tier> tiers = new ArrayList<>();

            tiers.add(tier1);
            tiers.add(tier2);
            tiers.add(tier3);
            tiers.add(tier4);

            Car car = new Car(model,eng,cargo,tiers);

            cars.add(car);
        }

        String command = reader.readLine();

        cars.stream()
                .filter(x -> {
                    if (x.getCargo().getCargoType().equals(command)) {
                        if(x.getTiers()
                                .stream()
                                .filter(y -> y.getPressure() < 1)
                                .count() > 0){
                            return true;
                        }
                        return false;
                    }
                    return false;
                })
                .forEach(System.out::println);

        cars.stream()
                .filter(x -> {
                    if (x.getCargo().getCargoType().equals(command)) {
                        if(x.getEngine().getEnginePower() > 250){
                            return true;
                        }
                        return false;
                    }
                    return false;
                })
                .forEach(System.out::println);


    }
}
