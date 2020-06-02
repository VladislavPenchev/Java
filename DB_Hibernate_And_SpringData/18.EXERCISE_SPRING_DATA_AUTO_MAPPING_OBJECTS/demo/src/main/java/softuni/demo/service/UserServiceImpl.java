package softuni.demo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.demo.domain.dtos.UserLoginDto;
import softuni.demo.domain.dtos.UserRegisterDTO;
import softuni.demo.domain.entities.Role;
import softuni.demo.domain.entities.User;
import softuni.demo.repository.UserRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private ModelMapper modelMapper;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public String registerUser(UserRegisterDTO userRegisterDTO) {

        ValidatorFactory validatorFactory = Validation
                .byDefaultProvider()
                .configure()
                .buildValidatorFactory();

        StringBuilder sb = new StringBuilder();

        if(!userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())){
            sb.append("Passwords don't match.");
        }else if(validatorFactory.getValidator().validate(userRegisterDTO).size() > 0){
                    for (ConstraintViolation<UserRegisterDTO> violation : validatorFactory.getValidator().validate(userRegisterDTO)){
                        sb.append(violation.getMessage())
                        .append(System.lineSeparator());
                    }
        }else{
            User entity = this.modelMapper.map(userRegisterDTO, User.class);

            if(this.userRepository.count() == 0){
                entity.setRole(Role.ADMIN);
            }else{
                entity.setRole(Role.USER);
            }

            this.userRepository.saveAndFlush(entity);

            sb.append(String.format("%s was registered",entity.getFullName()));
        }
        return sb.toString().trim();
    }

    @Override
    public String loginUser(UserLoginDto userLoginDto) {

        ValidatorFactory validatorFactory = Validation
                .byDefaultProvider()
                .configure()
                .buildValidatorFactory();

        StringBuilder sb = new StringBuilder();

        Set<ConstraintViolation<UserLoginDto>> violations = validatorFactory.getValidator().validate(userLoginDto);

        if(violations.size() > 0){
            for(ConstraintViolation<UserLoginDto> violation : violations){
                sb.append(violation.getMessage())
                        .append(System.lineSeparator());
            }
        } else {
            User entity = this.userRepository.findByEmail(userLoginDto.getEmail()).orElse(null);

            if(entity == null){
                 return sb.append("User does not exist.")
                .append(System.lineSeparator()).toString();
            } else if(!entity.getPassword().equals(userLoginDto.getPassword())) {
                return sb.append("Wrong password.")
                        .append(System.lineSeparator()).toString();
            }

            sb.append(String.format("Successfully logged in %s", entity.getFullName()))
            .append(System.lineSeparator());
        }


        return sb.toString().trim();
    }
}
