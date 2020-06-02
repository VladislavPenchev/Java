package ComaringObjects_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();

        String line;
        while (!"END".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");

            Person person = new Person(tokens[0], tokens[2], Integer.parseInt(tokens[1]));

            people.add(person);
        }

        int n = Integer.parseInt(reader.readLine());

        if(n < 0 || n >= people.size()) {
            System.out.println("No matches");
            return;
        }

        Person person = people.get(n);

        int countOfEqualsPeople = (int) people.stream()
                .filter(person1 -> person1.compareTo(person) == 0)
                .count();

        if(countOfEqualsPeople == 0){
            System.out.println("No matches");
        } else {
            System.out.println(String.format("%d %d %d", countOfEqualsPeople, people.size() - countOfEqualsPeople, people.size()));
        }
    }
}
