package regapp.repository;

import org.hibernate.annotations.GenericGenerator;
import regapp.domain.entities.Employee;

public interface EmployeeRepository extends GenericRepository<Employee, String> {
}
