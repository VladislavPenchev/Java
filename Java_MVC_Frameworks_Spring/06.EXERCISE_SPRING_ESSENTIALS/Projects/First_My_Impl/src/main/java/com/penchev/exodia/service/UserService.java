package com.penchev.exodia.service;

import com.penchev.exodia.domain.models.sevice.UserServiceModel;

public interface UserService {
    boolean registerUser(UserServiceModel userServiceModel);

    UserServiceModel loginUser(UserServiceModel userServiceModel);
}
