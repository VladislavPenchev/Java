package regapp.config;

import org.modelmapper.ModelMapper;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.enterprise.inject.Produces;

public class ApplicationBeanConfiguration {

    @Produces
    public EntityManager entityManager(){
        return Persistence.createEntityManagerFactory("registerPU")
                .createEntityManager();
    }

    @Produces
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
