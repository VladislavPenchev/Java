package softuni.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.demo.services.base.DepartmentsService;
import softuni.demo.services.base.EmployeeService;

@Component
public class Application implements CommandLineRunner {

    @Autowired
    DepartmentsService departmentsService;

    @Autowired
    EmployeeService employeeService;

    @Override
    public void run(String... args) throws Exception {

        departmentsService.getAllDepartments()
                .forEach(System.out::println);


        System.out.println("-------------------");

        employeeService.getAllEmployees()
                .forEach(System.out::println);
    }
}
