package Mankind_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] studentArgs = currentLine(bufferedReader).split("\\s+");
            String firstNameStudent = studentArgs[0];
            String lastNameStudent = studentArgs[1];
            String facultyNumber = studentArgs[2];

            Student student = new Student(firstNameStudent, lastNameStudent, facultyNumber);

            String[] workerArgs = currentLine(bufferedReader).split("\\s+");
            String firstNameWorker = workerArgs[0];
            String lastNameWorker = workerArgs[1];
            BigDecimal salary = new BigDecimal(workerArgs[2]);
            int workingHours = Integer.parseInt(workerArgs[3]);

            Worker worker = new Worker(firstNameWorker, lastNameWorker, salary, workingHours);

            System.out.println(student.toString());
            System.out.println(worker.toString());
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }

    }

    private static String currentLine(BufferedReader reader) throws IOException {
        return reader.readLine();
    }
}
