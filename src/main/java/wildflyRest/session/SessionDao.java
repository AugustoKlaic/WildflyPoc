package wildflyRest.session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
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

    @Transactional
    public void closeSession(UUID agendaId) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE SessionEntity s SET s.status = false WHERE s.sessionAgenda = :id");
        query.setParameter("id", agendaId);
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }

    public SessionEntity getSession(UUID id) {
        Query query = entityManager.createQuery("SELECT s from SessionEntity s WHERE s.id = :id");
        query.setParameter("id", id);
        return (SessionEntity) query.getSingleResult();
    }

    public List<SessionEntity> getAllSessions() {
        Query query = entityManager.createQuery("SELECT s from SessionEntity s");
        return (List<SessionEntity>) query.getResultList();
    }
}
