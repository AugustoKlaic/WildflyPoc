package wildflyRest.dao;

import wildflyRest.entity.VoteEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

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
        entityManager.persist(vote);
    }

    public Integer
}
