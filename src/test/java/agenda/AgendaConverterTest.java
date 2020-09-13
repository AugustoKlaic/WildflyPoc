package agenda;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import wildflyRest.agenda.AgendaConverter;
import wildflyRest.agenda.AgendaEntity;
import wildflyRest.agenda.AgendaInput;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class AgendaConverterTest {

    @InjectMocks
    private AgendaConverter agendaConverter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testIfConvertToEntity() {
        AgendaInput agendaInput = createAgendaInput();

        AgendaEntity response = agendaConverter.convertInputToEntity(agendaInput);

        assertEquals(agendaInput.getName(), response.getName());
    }

    private AgendaInput createAgendaInput() {
        final AgendaInput agendaInput = new AgendaInput();
        agendaInput.setName("Test Agenda Input");

        return agendaInput;
    }

    private AgendaEntity createAgenda() {
        final AgendaEntity agendaEntity = new AgendaEntity();
        agendaEntity.setId(UUID.fromString("dddfd8f6-c45e-41d5-86ef-910ac3ca6cfa"));
        agendaEntity.setName("Test Agenda");

        return agendaEntity;
    }
}
