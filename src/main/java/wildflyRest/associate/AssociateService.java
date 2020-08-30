package wildflyRest.associate;

import javax.transaction.Transactional;
import java.util.List;

public class AssociateService {

    private final AssociateDao associateDao = new AssociateDao();

    public List<AssociateEntity> getAllAssociates() {
        return associateDao.getAllAssociates();
    }

    @Transactional
    public String insertAssociate(AssociateEntity associateEntity) {
        if (associateEntity != null && associateEntity.getCpf() != null && associateEntity.getName() != null) {
            return associateDao.insertAssociate(associateEntity);
        } else return null;
    }
}
