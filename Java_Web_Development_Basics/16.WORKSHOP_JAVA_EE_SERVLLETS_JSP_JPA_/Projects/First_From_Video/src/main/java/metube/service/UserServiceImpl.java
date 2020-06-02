package metube.service;

import metube.domain.entities.User;
import metube.domain.models.service.UserServiceModel;
import metube.domain.util.Mapper;
import metube.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;

import javax.inject.Inject;

public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final Mapper mapper;

    @Inject
    public UserServiceImpl(UserRepository userRepository, Mapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public boolean registerUser(UserServiceModel userServiceModel) {
        User user = this.mapper.map(userServiceModel, User.class);
        user.setPassword(DigestUtils.sha256Hex(userServiceModel.getPassword()));

        try {
            this.userRepository.save(user);
        } catch(Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public boolean loginUser(UserServiceModel userServiceModel) {
        if(this.userRepository.findByUsernameAndPassword(userServiceModel.getUsername(),
                DigestUtils.sha256Hex(userServiceModel.getPassword())) != null) {
            return true;
        }

        return false;
    }
}
