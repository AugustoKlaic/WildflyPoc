package wildflyRest.dao;

import wildflyRest.entity.AssociateEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

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

    @Transactional
    public AssociateEntity getAssociate(UUID id) {
        Query query = entityManager.createQuery("SELECT a from AssociateEntity a WHERE a.id = :id");
        query.setParameter("id", id);
        return (AssociateEntity) query.getSingleResult();
    }
}
