package wildflyRest.dao;

import wildflyRest.entity.SessionEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.UUID;

import static javax.persistence.Persistence.createEntityManagerFactory;

public class SessionDao {

    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;

    public SessionDao() {
        entityManagerFactory = createEntityManagerFactory("Wildfly-POC");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Transactional
    public UUID insertSession(SessionEntity session) {
        entityManager.getTransaction().begin();
        entityManager.persist(session);
        entityManager.getTransaction().commit();
        return session.getId();
    }
}
