package softuni.demo.services.base;

import softuni.demo.dtos.DepartmentDTO;

import java.util.List;

public interface DepartmentsService {

    List<DepartmentDTO> getAllDepartments();
}
