import entities.Person;
import entities.Student;
import entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = factory.createEntityManager();

        Person[] people =
                {
                    new Student("Pesho" + Math.random(), 3),
                    new Teacher("Gosho" + Math.random(),"Java")
                };
        entityManager.getTransaction().begin();

        Arrays.stream(people)
                .forEach(entityManager::persist);

        entityManager.getTransaction().commit();
    }
}
