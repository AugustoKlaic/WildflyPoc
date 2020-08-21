package wildflyRest.dao;

import wildflyRest.dto.output.VoteResultOutput;
import wildflyRest.entity.VoteEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;

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

    public VoteResultOutput votingResult(UUID agendaId) {
        Query query = entityManager.createNativeQuery("SELECT COUNT(v.vote_value) FILTER(WHERE v.vote_value = true) as yes," +
                " COUNT(v.vote_value) FILTER(WHERE v.vote_value = false) as no," +
                " COUNT(v.vote_value) as total" +
                " FROM vote v" +
                " WHERE v.vote_agenda = ?1 ");

        query.setParameter(1, agendaId);
        return (VoteResultOutput) query.getSingleResult();
    }
}
