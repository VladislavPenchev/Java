package metube.config;

import org.modelmapper.ModelMapper;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.ws.rs.Produces;

public class ApplicationBeanConfiguration {

    @Produces
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Produces
    public EntityManager entityManager() {
        return Persistence
                .createEntityManagerFactory("metube")
                .createEntityManager();
    }
}