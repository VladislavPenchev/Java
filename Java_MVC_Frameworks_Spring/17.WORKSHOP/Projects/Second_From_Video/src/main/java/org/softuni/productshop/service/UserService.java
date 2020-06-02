package org.softuni.productshop.service;

import org.softuni.productshop.domain.models.service.UserServiceModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByName(String username);

    UserServiceModel editUserProfile(UserServiceModel userServiceModel, String oldPassword);

}
