package wildflyRest.associate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

import static javax.persistence.Persistence.createEntityManagerFactory;

public class AssociateDao {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public AssociateDao() {
        entityManagerFactory = createEntityManagerFactory("Wildfly-POC");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public List<AssociateEntity> getAllAssociates() {
        Query query = entityManager.createQuery("SELECT a FROM AssociateEntity a");
        return (List<AssociateEntity>) query.getResultList();
    }

    public AssociateEntity getAssociate(String cpf) {
        Query query = entityManager.createQuery("SELECT a from AssociateEntity a WHERE a.cpf = :cpf");
        query.setParameter("cpf", cpf);
        return (AssociateEntity) query.getSingleResult();
    }

    @Transactional
    public String insertAssociate(AssociateEntity associate) {
        entityManager.getTransaction().begin();
        entityManager.persist(associate);
        entityManager.getTransaction().commit();
        return associate.getCpf();
    }
}
