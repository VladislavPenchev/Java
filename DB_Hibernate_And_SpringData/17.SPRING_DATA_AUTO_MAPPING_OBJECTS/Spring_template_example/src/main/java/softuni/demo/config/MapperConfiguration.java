package softuni.demo.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.demo.dtos.DepartmentDTO;
import softuni.demo.dtos.EmployeeDTO;
import softuni.demo.entities.Department;
import softuni.demo.entities.Employee;

@Configuration
public class MapperConfiguration {

    private static ModelMapper mapper = new ModelMapper();

    static {
        mapper = new ModelMapper();
        mapper.createTypeMap(Employee.class, EmployeeDTO.class)
                .addMapping(
                        entity -> entity.getDepartment().getName(),
                        EmployeeDTO::setDepartment
                );

//        mapper.createTypeMap(Department.class, DepartmentDTO.class)
//                .addMappings(new PropertyMap<Department, DepartmentDTO>() {
//                    @Override
//                    protected void configure() {
//                        var s = source;
//                        map().setEmployeesCount(
//                                source.getEmployees().size()
//                        );
//                    }
//                });

        mapper.validate();
    }

    @Bean
    public ModelMapper modelMapper(){
        return mapper;
    }
}
