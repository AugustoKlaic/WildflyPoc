package wildflyRest.service;

import wildflyRest.dao.AssociateDao;
import wildflyRest.entity.AssociateEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AssociateService {

    private AssociateDao associateDao = new AssociateDao();

    public List<AssociateEntity> getAllAssociates() {
        return associateDao.getAllAssociates();
    }

    public Optional<AssociateEntity> getAssociate(UUID associateId) {
        if(associateId != null){
            return Optional.of(associateDao.getAssociate(associateId));
        } else {
            return Optional.empty();
        }
    }
}
