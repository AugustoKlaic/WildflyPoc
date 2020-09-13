package associate;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import wildflyRest.associate.AssociateConverter;
import wildflyRest.associate.AssociateEntity;
import wildflyRest.associate.AssociateInput;

import static org.junit.Assert.assertEquals;

public class AssociateConverterTest {

    @InjectMocks
    private AssociateConverter associateConverter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testIfConvertToEntity() {
        AssociateInput associateInput = createAgendaInput();

        AssociateEntity response = associateConverter.convertInputToEntity(associateInput);

        assertEquals(associateInput.getAssociateName(), response.getName());
        assertEquals(associateInput.getAssociateCpf(), response.getCpf());
    }

    private AssociateInput createAgendaInput() {
        final AssociateInput associateInput = new AssociateInput();

        associateInput.setAssociateCpf("86101456759");
        associateInput.setAssociateName("Ribamar");

        return associateInput;
    }
}
