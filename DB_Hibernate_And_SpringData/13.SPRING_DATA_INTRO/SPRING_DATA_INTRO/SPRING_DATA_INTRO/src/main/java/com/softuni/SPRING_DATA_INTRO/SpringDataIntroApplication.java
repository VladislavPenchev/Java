package com.softuni.SPRING_DATA_INTRO;

import com.softuni.SPRING_DATA_INTRO.entities.Employee;
import com.softuni.SPRING_DATA_INTRO.repositories.EmployeesCrudRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class SpringDataIntroApplication {

	public SpringDataIntroApplication(EmployeesCrudRepository employeesRepository){

//		Iterable<Employee> employees = employeesRepository.findAllByFirstNameStartingWith("P");
//
//		for(Employee emp : employees){
//			System.out.println(emp.getFirstName());
//		}


	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataIntroApplication.class, args);
	}

}
