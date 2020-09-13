package session;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import wildflyRest.session.SessionConverter;
import wildflyRest.session.SessionEntity;
import wildflyRest.session.SessionInput;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.Assert.*;

public class SessionConverterTest {

    @InjectMocks
    private SessionConverter sessionConverter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testIfConvertToEntity() {
        SessionInput sessionInput = createSessionInput();

        SessionEntity response = sessionConverter.convertInputToEntity(sessionInput);

        assertEquals(sessionInput.getSessionAgenda(), response.getSessionAgenda());
        assertEquals(LocalDateTime.parse(sessionInput.getSessionCreateTime()), response.getSessionCreateTime());
        assertEquals(LocalDateTime.parse(sessionInput.getSessionDuration()), response.getSessionDuration());
        assertTrue(response.getStatus());
    }

    @Test
    public void testIfDurationIsSetToNull(){
        SessionInput sessionInput = createSessionInput();
        sessionInput.setSessionDuration(null);
        SessionEntity response = sessionConverter.convertInputToEntity(sessionInput);

        assertNull(response.getSessionDuration());
    }

    private SessionInput createSessionInput() {
        final SessionInput sessionInput = new SessionInput();

        sessionInput.setSessionAgenda(UUID.fromString("dddfd8f6-c45e-41d5-86ef-910ac3ca6cfa"));
        sessionInput.setSessionCreateTime("2020-09-01T21:41:00");
        sessionInput.setSessionDuration("2020-09-01T21:41:00");

        return sessionInput;
    }
}
