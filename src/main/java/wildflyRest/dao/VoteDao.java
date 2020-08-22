package wildflyRest.dao;

import wildflyRest.entity.VoteEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

import static javax.persistence.Persistence.createEntityManagerFactory;

public class VoteDao {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public VoteDao() {
        entityManagerFactory = createEntityManagerFactory("Wildfly-POC");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Transactional
    public void vote(VoteEntity vote) {
        entityManager.getTransaction().begin();
        entityManager.persist(vote);
        entityManager.getTransaction().commit();
    }

    public List<VoteEntity> votingResult(UUID agendaId) {
        Query query = entityManager.createQuery("SELECT v FROM VoteEntity v WHERE v.voteAgenda = :agendaId ");

        query.setParameter("agendaId", agendaId);
        return (List<VoteEntity>) query.getResultList();
    }
}
