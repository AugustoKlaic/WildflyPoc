package wildflyRest.dao;

import wildflyRest.entity.AssociateEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

import static javax.persistence.Persistence.createEntityManagerFactory;

public class AssociateDao {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public AssociateDao() {
        entityManagerFactory = createEntityManagerFactory("Wildfly-POC");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public List<AssociateEntity> getAllAssociates() {
        Query query = entityManager.createQuery("SELECT a FROM AssociateEntity a");
        return (List<AssociateEntity>) query.getResultList();
    }

    public AssociateEntity getAssociate(UUID id) {
        Query query = entityManager.createQuery("SELECT a from AssociateEntity a WHERE a.id = :id");
        query.setParameter("id", id);
        return (AssociateEntity) query.getSingleResult();
    }

    @Transactional
    public UUID insertAssociate(AssociateEntity associate) {
        entityManager.getTransaction().begin();
        entityManager.persist(associate);
        entityManager.getTransaction().commit();
        return associate.getId();
    }
}
