package wildflyRest.session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.UUID;

import static javax.persistence.Persistence.createEntityManagerFactory;

public class SessionDao {

    private final EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private final EntityManager entityManager;

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

    public SessionEntity getSession(UUID id) {
        Query query = entityManager.createQuery("SELECT s from SessionEntity s WHERE s.id = :id");
        query.setParameter("id", id);
        return (SessionEntity) query.getSingleResult();
    }
}
