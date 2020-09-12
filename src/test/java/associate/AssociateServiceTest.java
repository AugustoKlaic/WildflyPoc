package associate;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import wildflyRest.associate.AssociateDao;
import wildflyRest.associate.AssociateEntity;
import wildflyRest.associate.AssociateService;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class AssociateServiceTest {

    @InjectMocks
    private AssociateService associateService;

    @Mock
    private AssociateDao associateDao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testIfInsertAssociate() {
        final AssociateEntity associateEntity = createAssociate();
        when(associateDao.insertAssociate(any(AssociateEntity.class))).thenReturn(associateEntity.getCpf());

        assertEquals(associateEntity.getCpf(), associateService.insertAssociate(associateEntity));
    }

    @Test
    public void testIfGetAllAssociates(){
        final List<AssociateEntity> associates = Arrays.asList(createAssociate(), createAssociate());
        when(associateDao.getAllAssociates()).thenReturn(associates);

        assertEquals(2, associateService.getAllAssociates().size());
        assertEquals(createAssociate().getCpf(), associates.get(0).getCpf());
    }

    private AssociateEntity createAssociate() {
        final AssociateEntity associateEntity = new AssociateEntity();

        associateEntity.setCpf("35058318083");
        associateEntity.setName("Ribamar");

        return associateEntity;
    }
}
