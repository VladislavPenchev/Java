package softuni.demo.service;

import softuni.demo.domain.dtos.UserLoginDto;
import softuni.demo.domain.dtos.UserRegisterDTO;

public interface UserService {

    String registerUser(UserRegisterDTO userRegisterDTO);

    String loginUser(UserLoginDto userLoginDto);
}
