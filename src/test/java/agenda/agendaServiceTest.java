package agenda;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import wildflyRest.agenda.AgendaDao;
import wildflyRest.agenda.AgendaEntity;
import wildflyRest.agenda.AgendaService;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class agendaServiceTest {

    @InjectMocks
    private AgendaService agendaService;

    @Mock
    private AgendaDao agendaDao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testIfInsertAgenda() {
        final AgendaEntity agendaEntity = createAgenda();
        when(agendaDao.insertAgenda(any(AgendaEntity.class))).thenReturn(agendaEntity.getId());

        assertEquals(agendaService.insertAgenda(agendaEntity), agendaEntity.getId());
    }

    @Test
    public void testIfGetAllAgendas() {
        final List<AgendaEntity> agendas = Arrays.asList(createAgenda(), createAgenda());
        when(agendaDao.getAllAgendas()).thenReturn(agendas);

        assertEquals(2, agendaService.getAllAgendas().size());
        assertEquals(createAgenda().getId(), agendas.get(0).getId());
    }

    private AgendaEntity createAgenda() {
        final AgendaEntity agendaEntity = new AgendaEntity();
        agendaEntity.setId(UUID.fromString("dddfd8f6-c45e-41d5-86ef-910ac3ca6cfa"));
        agendaEntity.setName("Test Agenda");

        return agendaEntity;
    }
}
