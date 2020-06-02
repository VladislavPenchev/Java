package GenericBoxOfInteger_fd_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countOfBoxParameters = Integer.parseInt(reader.readLine());

        List<Box<Integer>> boxes = new ArrayList<>();


        while(countOfBoxParameters-- > 0){

            int line = Integer.parseInt(reader.readLine());

            Box<Integer> box = new Box<>();

            box.setValue(line);

            boxes.add(box);

        }

        boxes.forEach(System.out::println);

    }
}
