package CarSalesman_fd_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final int numberOfParameters_3 = 3;
    public static final int numberOfParameters_4 = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countOfEngines = Integer.parseInt(reader.readLine());

        List<Engine> engines = new ArrayList();
        List<Car> cars = new ArrayList<>();

        String[] line;
        for (int i = 0; i < countOfEngines; i++) {
            line = reader.readLine().split("\\s+");

            String engineModel = line[0];
            int enginePower = Integer.parseInt(line[1]);

            Engine eng = new Engine(engineModel, enginePower);

            if (line.length == numberOfParameters_3) {
                if(tryParseInt(line[2])){
                    int displacement = Integer.parseInt(line[2]);
                    eng.setDisplacement(displacement);
                }else{
                    String efficiency = line[2];
                    eng.setEfficiency(efficiency);
                }
            }else if(line.length == numberOfParameters_4){
                int displacement = Integer.parseInt(line[2]);
                String efficiency = line[3];
                eng.setDisplacement(displacement);
                eng.setEfficiency(efficiency);
            }

            engines.add(eng);
        }

        int countOfCars = Integer.parseInt(reader.readLine());

        for(int j = 0; j < countOfCars; j++){
            line = reader.readLine().split("\\s+");

            String carModel =line[0];
            String carEngine = line[1];

            Engine eng = (Engine) engines.stream()
                    .filter(x -> x.getModel().equals(carEngine))
                    .findFirst()
                    .get();


            Car car = new Car(carModel,eng);

            if (line.length == numberOfParameters_3) {
                if(tryParseInt(line[2])){
                    int carWeight = Integer.parseInt(line[2]);
                    car.setWeight(carWeight);
                }else{
                    String color = line[2];
                    car.setColor(color);
                }
            }else if(line.length == numberOfParameters_4){
                int carWeight = Integer.parseInt(line[2]);
                String color = line[3];
                car.setWeight(carWeight);
                car.setColor(color);
            }
            cars.add(car);
        }



        cars.stream()
                .forEach(System.out::println);

    }

    public static boolean tryParseInt (String value){
        try{
            Integer.parseInt(value);
            return  true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}