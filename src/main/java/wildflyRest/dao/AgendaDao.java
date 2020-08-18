package wildflyRest.dao;

import wildflyRest.entity.AgendaEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

import static javax.persistence.Persistence.createEntityManagerFactory;

public class AgendaDao {

    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;

    public AgendaDao() {
        entityManagerFactory = createEntityManagerFactory("Wildfly-POC");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public List<AgendaEntity> getAllAgendas() {
        Query query = entityManager.createQuery("SELECT a FROM AgendaEntity a");
        return (List<AgendaEntity>) query.getResultList();
    }

    public AgendaEntity getAgenda(UUID agendaId) {
        Query query = entityManager.createQuery("SELECT a from AgendaEntity a WHERE a.id = :agendaId");
        query.setParameter("agendaId", agendaId);
        return (AgendaEntity) query.getSingleResult();
    }

    @Transactional
    public UUID insertAgenda(AgendaEntity agenda) {
        entityManager.getTransaction().begin();
        entityManager.persist(agenda);
        entityManager.getTransaction().commit();
        return agenda.getId();
    }
}
