package StrategyPattern_06;

import StrategyPattern_06.comparators.ComparatorByPersonAge;
import StrategyPattern_06.comparators.ComparatorByPersonNameLengthThenFirstNameLetter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> treeSetByName = new TreeSet<>(new ComparatorByPersonNameLengthThenFirstNameLetter());

        Set<Person> treeSetByAge = new TreeSet<>(new ComparatorByPersonAge());

        int n = Integer.parseInt(bufferedReader.readLine());

        while(n-- > 0) {
            String[] tokens = bufferedReader.readLine().split("\\s+");

            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));

            treeSetByName.add(person);
            treeSetByAge.add(person);
        }

        treeSetByName.forEach(System.out::println);
        treeSetByAge.forEach(System.out::println);
    }
}
