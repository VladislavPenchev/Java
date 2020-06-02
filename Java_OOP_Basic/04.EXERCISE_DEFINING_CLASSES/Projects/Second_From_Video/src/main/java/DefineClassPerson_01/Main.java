package DefineClassPerson_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Person person = new Person();
        person.setName("Gosho");
        person.setAge(20);

        if(person.getName().equals("Gosho")){
            System.out.println(person.getAge());
        }
    }
}
