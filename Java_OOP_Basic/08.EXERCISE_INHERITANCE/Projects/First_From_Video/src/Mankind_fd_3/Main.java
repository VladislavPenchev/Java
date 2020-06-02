package Mankind_fd_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String[] studentLine = reader.readLine().split("\\s+");

            String studentFirstName = studentLine[0];
            String studentLastName = studentLine[1];
            String studentFacultyNumbere = studentLine[2];

            Human student = new Student(studentFirstName,studentLastName,studentFacultyNumbere);

            String[] workerLine = reader.readLine().split("\\s+");

            String workerFirstName = workerLine[0];
            String workerLastName = workerLine[1];
            double workerWeekSalary = Double.parseDouble(workerLine[2]);
            double workerHoursPerDay = Double.parseDouble(workerLine[3]);

            Human worker = new Worker(workerFirstName,workerLastName,workerWeekSalary,workerHoursPerDay);

            System.out.println(student);
            System.out.println(worker);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
