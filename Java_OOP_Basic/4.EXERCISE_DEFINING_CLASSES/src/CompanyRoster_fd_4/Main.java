package CompanyRoster_fd_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Employee> employees = new ArrayList<>();

        int countOfEmployees = Integer.parseInt(reader.readLine());

        for(int i = 0; i < countOfEmployees; i++){

            String[] line = reader.readLine().split("\\s+");

            int lineCount = line.length;

            String name = line[0];
            double salary = Double.parseDouble(line[1]);
            String position = line[2];
            String department = line[3];

            Employee emp = null;

            switch(lineCount){
                case 4:
                    emp = new Employee(name,salary,position,department);
                    break;

                case 5:
                    if(line[4].matches("\\d+")){
                        int age = Integer.parseInt(line[4]);
                        emp = new Employee(name,salary,position,department,age);
                    }else{
                        String email = line[4];
                        emp = new Employee(name,salary,position,department,email);
                    }
                    break;

                case 6:
                    String email = line[4];
                    int age = Integer.parseInt(line[5]);
                    emp = new Employee(name,salary,position,department,email,age);
                    break;
            }

            employees.add(emp);
        }

        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet()
                .stream()
                .sorted((e1,e2) ->
                        Double.compare(
                                e2.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble(),
                                e1.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble()
                        ))
                .limit(1)
                .forEach(d -> {
                    StringBuilder result = new StringBuilder();

                    result.append(String.format("Highest Average Salary: %s",d.getKey()))
                            .append(System.lineSeparator());

                    d.getValue()
                            .stream()
                            .sorted(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder()))
                            .forEach(employee ->  result.append(employees).append(System.lineSeparator()));
                    System.out.print(result.toString());
                });


    }
}
