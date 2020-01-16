package wildflyRest.dao;

import wildflyRest.entity.AssociateEntity;

import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

public class AssociateDao {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public AssociateDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("Wildfly-POC");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Transactional
    public List<AssociateEntity> getAllAssociates() {
        Query query = entityManager.createQuery("SELECT a FROM AssociateEntity a");

        return (List<AssociateEntity>) query.getResultList();
    }
}
