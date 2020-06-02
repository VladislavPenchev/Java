package softuni.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.demo.entities.Department;

@Repository
public interface DepartmentsRepository extends JpaRepository<Department, Long> {
}
