package CompanyRoster_04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int inputLine = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < inputLine; i++) {
            String currentLine = scanner.nextLine();
            String[] currentLineArgs = currentLine.split("\\s+");
            String name = currentLineArgs[0];
            Double salary = Double.parseDouble(currentLineArgs[1]);
            String position = currentLineArgs[2];
            String department = currentLineArgs[3];
            String email = "";
            int age = 0;

            if (!tryParseInt(currentLineArgs[4])) {
                email = currentLineArgs[4];
            } else {
                age = Integer.parseInt(currentLineArgs[4]);
            }

            if (currentLineArgs.length == 6) {
                age = Integer.parseInt(currentLineArgs[5]);
            }

            Employee employee = new Employee();

            switch (currentLineArgs.length) {
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
                case 5:
                    if (!"".equals(email)) {
                        employee = new Employee(name, salary, position, department, email);
                    } else {
                        employee = new Employee(name, salary, position, department, age);
                    }
                    break;
                case 6:
                    employee = new Employee(name, salary, position, department, email, age);
                    break;
            }

            employees.add(employee);
        }

        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Double.compare(
                        e2.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble(),
                        e1.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble()))
                .limit(1)
                .forEach(d -> {
                    StringBuilder result = new StringBuilder();
                    result.append(String.format("Highest Average Salary: %s", d.getKey()))
                            .append(System.lineSeparator());
                    d.getValue()
                            .stream()
                            .sorted(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder()))
                            .forEach(
                                    emp -> result.append(String.format("%s %.2f %s %d",
                                        emp.getName(),
                                        emp.getSalary(),
                                        emp.getEmail() == null ? "n/a" : emp.getEmail(),
                                        emp.getAge() == 0 ? -1 : emp.getAge()))
                                    .append(System.lineSeparator())
                            );
                    System.out.println(result.toString());
                });
    }

    private static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
