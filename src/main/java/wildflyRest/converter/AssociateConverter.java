package wildflyRest.converter;

import wildflyRest.dto.input.AssociateInput;
import wildflyRest.entity.AssociateEntity;

import javax.inject.Singleton;

@Singleton
public class AssociateConverter {

    public static AssociateEntity convertInputToEntity(AssociateInput associateInput){
        final AssociateEntity associateEntity = new AssociateEntity();

        associateEntity.setCpf(associateInput.getAssociateCpf());
        associateEntity.setName(associateInput.getAssociateName());

        return associateEntity;
    }
}
