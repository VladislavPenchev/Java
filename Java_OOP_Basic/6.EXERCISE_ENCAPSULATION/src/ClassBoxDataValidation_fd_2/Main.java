package ClassBoxDataValidation_fd_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double length = Double.parseDouble(reader.readLine());
        double width = Double.parseDouble(reader.readLine());
        double height = Double.parseDouble(reader.readLine());

        Box box = null;

        try{
            box = new Box(length,width,height);

            System.out.println(box);
        }catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }


    }
}
