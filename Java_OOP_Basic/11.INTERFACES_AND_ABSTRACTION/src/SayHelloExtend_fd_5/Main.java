package SayHelloExtend_fd_5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> people = new ArrayList(){{
            add(new Bulgarian("Strahil"));
            add(new European("dasa"));
            add(new Chinese("vingchung"));
        }} ;

        for(Person person : people){
            PrintPerson(person);
        }
    }

    private static void PrintPerson(Person person) {
        System.out.println(person.sayHello());
    }
}
