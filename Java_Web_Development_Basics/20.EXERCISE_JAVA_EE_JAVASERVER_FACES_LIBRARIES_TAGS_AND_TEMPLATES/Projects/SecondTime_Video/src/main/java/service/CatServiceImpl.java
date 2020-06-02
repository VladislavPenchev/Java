package service;

import domain.entities.Cat;
import domain.models.service.CatServiceModel;
import org.modelmapper.ModelMapper;
import repository.CatRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;
    private final ModelMapper modelMapper;

    @Inject
    public CatServiceImpl(CatRepository catRepository, ModelMapper modelMapper) {
        this.catRepository = catRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean saveCat(CatServiceModel catServiceModel) {

        try{
            this.catRepository.save(this.modelMapper.map(catServiceModel, Cat.class));
        }catch(Exception e){
            return false;
        }

        return true;
    }

    @Override
    public List<CatServiceModel> findAllCats() {
        return this.catRepository.findAll().stream().map(e -> this.modelMapper.map(e, CatServiceModel.class))
                .collect(Collectors.toList());
    }
}
