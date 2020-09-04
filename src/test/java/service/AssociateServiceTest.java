package service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import wildflyRest.associate.AssociateDao;
import wildflyRest.associate.AssociateEntity;
import wildflyRest.associate.AssociateService;

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

    private AssociateEntity createAssociate() {
        final AssociateEntity associateEntity = new AssociateEntity();

        associateEntity.setCpf("35058318083");
        associateEntity.setName("Ribamar");

        return associateEntity;
    }
}
