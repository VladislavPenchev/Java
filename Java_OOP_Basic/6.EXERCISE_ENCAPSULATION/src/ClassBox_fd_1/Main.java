package ClassBox_fd_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            double length = Double.parseDouble(reader.readLine());
            double width = Double.parseDouble(reader.readLine());
            double height = Double.parseDouble(reader.readLine());

            Box box = new Box(length,width,height);

            //2lw + 2lh + 2wh
            double surfaceArea = (2*length*width) + (2*length*height) + (2*width*height);

            //2lh + 2wh
            double leteralSurface = (2*length*height) + (2*width*height);

            //lwh
            double volume = length*width*height;

            StringBuilder sb = new StringBuilder();

            sb.append(String.format("Surface Area - %.2f",surfaceArea))
                    .append(System.lineSeparator())
                    .append(String.format("Lateral Surface Area - %.2f",leteralSurface))
                    .append(System.lineSeparator())
                    .append(String.format("Volume - %.2f",volume));

        System.out.println(sb);
    }
}
