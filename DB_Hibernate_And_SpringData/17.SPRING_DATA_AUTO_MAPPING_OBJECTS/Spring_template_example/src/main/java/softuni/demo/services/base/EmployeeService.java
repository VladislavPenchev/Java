package softuni.demo.services.base;

import softuni.demo.dtos.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();
}
