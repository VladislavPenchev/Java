package com.softuni.SPRING_DATA_INTRO.repositories;

import com.softuni.SPRING_DATA_INTRO.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesCrudRepository extends CrudRepository<Employee, Long> {

    Iterable<Employee> findAllByFirstNameStartingWith(String prefix);

    Iterable<Employee> findAllDistinctByFirstNameAndOrderByLastName();

    Iterable<Employee> findById();

}
