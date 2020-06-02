package GenricBox_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int countOfLines = Integer.parseInt(bufferedReader.readLine());

        List<Box<Integer>> boxes = new ArrayList<Box<Integer>>();

        for (int i = 0; i < countOfLines; i++) {
            String line = bufferedReader.readLine();

            Box<Integer> box = new Box<Integer>(Integer.parseInt(line));

            boxes.add(box);
        }

        boxes.forEach(System.out::println);
    }
}
