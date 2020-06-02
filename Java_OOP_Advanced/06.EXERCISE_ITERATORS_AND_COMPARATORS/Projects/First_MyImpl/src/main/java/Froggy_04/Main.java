package Froggy_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Stream.of(reader.readLine().split("[, ]+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Lake<Integer> lake = new Lake<>(numbers);

        lake.forEach(System.out::println);
    }
}
