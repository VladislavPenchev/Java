package CarSalesman_fd_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final int numberOfParameters_3 = 3;
    public static final int numberOfParameters_4 = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countOfEngines = Integer.parseInt(reader.readLine());

        String[] line;
        for (int i = 0; i < countOfEngines; i++) {
            line = reader.readLine().split("\\s+");

            String engineModel = line[0];
            int enginePower = Integer.parseInt(line[1]);
            int displacement = Integer.parseInt(line[2]);
            String efficiency = line[3];

            Engine eng = new Engine(engineModel, enginePower);

            if (line.length == numberOfParameters_3) {
                if(tryParseInt(line[3])){

                    eng.setDisplacement(displacement);
                }else{
                    eng.setEfficiency(efficiency);
                }
            }else if(line.length == numberOfParameters_4){
                eng.setDisplacement(displacement);
                eng.setEfficiency(efficiency);
            }


        }

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