package CompanyRoster_fd_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Employee> employees = new ArrayList<>();

        int countOfEmployees = Integer.parseInt(reader.readLine());

        for(int i = 0; i < countOfEmployees; i++){

            String[] line = reader.readLine().split("\\s+");

            int lineCount = line.length;

            Employee emp = shatter(line);

            switch(lineCount){
                case 5:
                    if(line[4].matches("\\d+")){
                        int age = Integer.parseInt(line[4]);
                        emp.setAge(age);
                    }else{
                        String email = line[4];
                        emp.setEmail(email);
                    }
                    break;

                case 6:
                    int age = Integer.parseInt(line[5]);
                    emp.setAge(age);
                    break;
            }

            employees.add(emp);
        }




    }

    private static Employee shatter(String[] line) {
        String name = line[0];
        double salary = Double.parseDouble(line[1]);
        String position = line[2];
        Department department = new Department(line[3]);

        Employee employee = new Employee(name,salary,position,department);

        return employee;
    }
}
