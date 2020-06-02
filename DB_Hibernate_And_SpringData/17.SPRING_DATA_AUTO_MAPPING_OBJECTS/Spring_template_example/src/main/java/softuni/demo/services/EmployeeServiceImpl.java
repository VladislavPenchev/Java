package softuni.demo.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.demo.dtos.EmployeeDTO;
import softuni.demo.repositories.EmployeesRepository;
import softuni.demo.services.base.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeesRepository employeesRepository;
    private final ModelMapper mapper;

    public EmployeeServiceImpl(EmployeesRepository employeesRepository, ModelMapper mapper){
        this.employeesRepository = employeesRepository;
        this.mapper = mapper;
    }



    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeesRepository.findAll()
                .stream()
                .map(employee -> mapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }
}
