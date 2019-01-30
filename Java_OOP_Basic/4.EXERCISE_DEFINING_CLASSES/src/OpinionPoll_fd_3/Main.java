package OpinionPoll_fd_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int personCount = Integer.parseInt(reader.readLine());

        List<Person> persons = new ArrayList<>();


        String[] line;
        for(int i = 0; i < personCount; i++){
            line = reader.readLine().split("\\s+");

            String name = line[0];
            int age = Integer.parseInt(line[1]);

            Person person = new Person(name,age);

            persons.add(person);
        }

        persons.stream()
                .filter(x -> x.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);




    }
}
