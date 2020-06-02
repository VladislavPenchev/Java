package metube.service;

import metube.domain.models.service.TubeServiceModel;
import metube.repository.TubeRepository;
import metube.util.Mapper;

import javax.inject.Inject;

public class TubeServiceImpl implements TubeService {

    private final TubeRepository tubeRepository;
    private final UserService userService;
    private final Mapper mapper;

    @Inject
    public TubeServiceImpl(TubeRepository tubeRepository, UserService userService, Mapper mapper) {
        this.tubeRepository = tubeRepository;
        this.userService = userService;
        this.mapper = mapper;
    }

    @Override
    public boolean uploadTube(TubeServiceModel tubeServiceModel) {
        return  false;
    }
}
