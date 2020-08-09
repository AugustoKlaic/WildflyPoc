package wildflyRest.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static javax.persistence.Persistence.createEntityManagerFactory;

public class AgendaDao {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public AgendaDao() {
        entityManagerFactory = createEntityManagerFactory("Wildfly-POC");
        entityManager = entityManagerFactory.createEntityManager();
    }
}
