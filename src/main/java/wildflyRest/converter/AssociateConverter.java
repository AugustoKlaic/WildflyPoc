package wildflyRest.converter;

import wildflyRest.dto.input.AssociateInput;
import wildflyRest.entity.AssociateEntity;

public class AssociateConverter {

    public static AssociateEntity convertInputToEntity(AssociateInput associateInput){
        final AssociateEntity associateEntity = new AssociateEntity();

        associateEntity.setCpf(associateInput.getAsociateCpf());
        associateEntity.setName(associateInput.getAssociateName());

        return associateEntity;
    }
}
