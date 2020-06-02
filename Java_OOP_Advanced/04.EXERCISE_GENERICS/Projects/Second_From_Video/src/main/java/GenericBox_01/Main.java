package GenericBox_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfRows = Integer.parseInt(reader.readLine());

        List<ComparableBox<String>> boxes = new ArrayList<>();

        while (numberOfRows-- > 0) {
            String input = reader.readLine();

            ComparableBox<String> box = new ComparableBox<>();
            box.setValue(input);
            boxes.add(box);
        }

        ComparableBox<String> box = new ComparableBox<>();
        box.setValue(reader.readLine());
        System.out.println(getCountOfGreaterElements(boxes, box));

//        int[] indexes = Stream.of(reader.readLine().split("\\s+"))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//
//        swap(boxes, indexes[0], indexes[1]);
//
//        boxes.forEach(System.out::println);
    }

    private static <T> void swap(List<Box<T>> boxes, int firstIndex, int secondIndex) {
        Box<T> firstBox = boxes.get(firstIndex);
        boxes.set(firstIndex, boxes.get(secondIndex));
        boxes.set(secondIndex, firstBox);
    }

    private static <T extends Comparable<T>> int getCountOfGreaterElements(List<ComparableBox<T>> elements, ComparableBox<T> singleElement) {
        return (int) elements.stream()
                .filter(element -> element.compareTo(singleElement) > 0)
                .count();
    }
}
