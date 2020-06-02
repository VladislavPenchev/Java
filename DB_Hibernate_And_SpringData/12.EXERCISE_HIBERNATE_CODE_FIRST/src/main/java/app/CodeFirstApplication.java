package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CodeFirstApplication {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("code_first_demo");

        EntityManager manager = factory.createEntityManager();

    }
}
