package softuni.demo.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.demo.dtos.DepartmentDTO;
import softuni.demo.entities.Department;
import softuni.demo.entities.Employee;
import softuni.demo.repositories.DepartmentsRepository;
import softuni.demo.services.base.DepartmentsService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {

    private final DepartmentsRepository departmentsRepository;
    private final ModelMapper mapper;

    public DepartmentsServiceImpl(DepartmentsRepository departmentsRepository, ModelMapper mapper){
        this.departmentsRepository = departmentsRepository;
        this.mapper = mapper;
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
//        return departmentsRepository.findAll()
//                .stream()
//                .map(department -> {
//                    DepartmentDTO dto = new DepartmentDTO();
//                    dto.setName(department.getName());
//                    dto.setEmployeesCount(department.getEmployees().size());
//                    return dto;
//                })
//                .collect(Collectors.toList());


        List<Department> departments =  departmentsRepository.findAll();

        return  departments.stream()
                .map(department -> mapper.map(department, DepartmentDTO.class))
                .collect(Collectors.toList());
    }
}
