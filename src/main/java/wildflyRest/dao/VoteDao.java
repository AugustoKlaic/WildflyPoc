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
        Query query = entityManager.createQuery(
                "SELECT " +
                        "new wildflyRest.dto.output.VoteResultOutput(" +
                        "SUM(case when v.voteValue = true then 1 else 0 end) as yes, " +
                        "SUM(case when v.voteValue = false then 1 else 0 end) as no, " +
                        "COUNT(v.voteValue) as total)" +
                        "FROM VoteEntity v " +
                        "WHERE v.voteAgenda = :agendaId ");

        query.setParameter("agendaId", agendaId);
        return (VoteResultOutput) query.getSingleResult();
    }
}
