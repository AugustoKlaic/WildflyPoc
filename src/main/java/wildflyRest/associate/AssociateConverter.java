package wildflyRest.associate;

import javax.inject.Singleton;

@Singleton
public class AssociateConverter {

    public AssociateEntity convertInputToEntity(AssociateInput associateInput) {
        final AssociateEntity associateEntity = new AssociateEntity();

        associateEntity.setCpf(associateInput.getAssociateCpf());
        associateEntity.setName(associateInput.getAssociateName());

        return associateEntity;
    }
}
