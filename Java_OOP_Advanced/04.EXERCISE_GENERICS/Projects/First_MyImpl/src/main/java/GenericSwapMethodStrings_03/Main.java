package GenericSwapMethodStrings_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int countOfLines = Integer.parseInt(bufferedReader.readLine());

        Boxes<Box<String>> boxes = new BoxesImpl<>();

        for (int i = 0; i < countOfLines; i++) {
            String line = bufferedReader.readLine();

            Box<String> box = new Box<>(line);

            boxes.addElement(box);
        }

        int[] commandArgs = Arrays.stream(bufferedReader.readLine().split("\\s+"))
                .mapToInt(Integer::valueOf)
                .toArray();

        boxes.swap(commandArgs[0], commandArgs[1]);

        boxes.forEach();

    }

}
