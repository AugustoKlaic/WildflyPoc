package service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import wildflyRest.associate.AssociateDao;
import wildflyRest.associate.AssociateEntity;
import wildflyRest.associate.AssociateService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;

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
        Mockito.when(associateDao.insertAssociate(any(AssociateEntity.class))).thenReturn(associateEntity.getCpf());

        String cpf = associateService.insertAssociate(associateEntity);
        assertEquals(cpf, associateEntity.getCpf());
    }

    public AssociateEntity createAssociate(){
        final AssociateEntity associateEntity = new AssociateEntity();

        associateEntity.setCpf("35058318083");
        associateEntity.setName("Ribamar");

        return associateEntity;
    }
}
