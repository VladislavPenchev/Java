package softuni.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.demo.entities.Employee;

public interface EmployeesRepository extends JpaRepository<Employee, Long> {
}
