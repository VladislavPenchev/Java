package GenericSwapMethodIntegers_fd_4;

import GenericBoxOfInteger_fd_2.Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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

        int[] indexes = Stream.of(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        swap(boxes, indexes[0], indexes[1]);

        boxes.forEach(System.out::println);
    }

    private static <T> void swap(List<Box<T>> boxes, int firstIndex, int secondIndex){
        Box<T> temp = boxes.get(firstIndex);

        boxes.set(firstIndex,boxes.get(secondIndex));

        boxes.set(secondIndex,temp);
    }
}
