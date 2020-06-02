package GenericCountMethodStrings_fd_5;

import GenericBoxOfInteger_fd_2.Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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

        Box<String> box = new Box<>();
        box.setValue(reader.readLine());

        //getCountOfGreaterElements(boxes, box);

        boxes.forEach(System.out::println);
    }

    private static <T> void swap(List<Box<T>> boxes, int firstIndex, int secondIndex){
        Box<T> temp = boxes.get(firstIndex);

        boxes.set(firstIndex,boxes.get(secondIndex));

        boxes.set(secondIndex,temp);
    }

    private static <T extends Comparable<T>> int getCountOfGreaterElements(List<T> elements, T singleElement){
        return elements.stream()
                .filter(element -> element.compareTo(singleElement) > 0)
                .collect(Collectors.toList())
                .size();
    }
}
