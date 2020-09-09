package service.session;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import wildflyRest.session.SessionDao;
import wildflyRest.session.SessionEntity;
import wildflyRest.session.SessionService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class SessionServiceTest {

    @InjectMocks
    private SessionService sessionService;

    @Mock
    private SessionDao sessionDao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testIfInsertSession() {
        final SessionEntity session = createSession();
        when(sessionDao.insertSession(any(SessionEntity.class))).thenReturn(session.getId());

        assertEquals(sessionService.insertSession(session), session.getId());
    }

    @Test
    public void testIfInsertReturnsNull() {
        final SessionEntity session = createSession();
        session.setSessionCreateTime(null);
        when(sessionDao.insertSession(any(SessionEntity.class))).thenReturn(session.getId());

        assertNull(sessionService.insertSession(session));
    }

    @Test
    public void testIfGetAllSessions() {
        when(sessionDao.getAllSessions()).thenReturn(Arrays.asList(createSession(), createSession()));

        final List<SessionEntity> sessions = sessionService.getAllSessions();

        assertEquals(2, sessions.size());
        assertEquals(createSession().getId(), sessions.get(0).getId());
    }

    @Test
    public void testIfCanGetSession() {
        final SessionEntity session = createSession();
        when(sessionDao.getSession(any(UUID.class))).thenReturn(session);

        assertEquals(session, sessionService.getSession(UUID.fromString("1c4265df-a31f-4c01-8854-4892dc32d085")));
    }

    @Test
    public void testIfCanCloseSession() {
        doNothing().when(sessionDao).closeSession(any(UUID.class));
        sessionService.closeSession(UUID.fromString("1c4265df-a31f-4c01-8854-4892dc32d085"));
        verify(sessionDao, times(1)).closeSession(UUID.fromString("1c4265df-a31f-4c01-8854-4892dc32d085"));
    }

    @Test
    public void testIfSessionIsClosed() {
        final SessionEntity session = createSession();
        session.setStatus(false);
        when(sessionDao.getSession(any(UUID.class))).thenReturn(session);

        assertTrue(sessionService.isSessionClosed(session.getId()));
    }

    @Test
    public void testIfSessionClosesWhenDurationExpires() {
        final SessionEntity session = createSession();
        session.setStatus(true);
        session.setSessionDuration(LocalDateTime.now().minusMinutes(1));
        when(sessionDao.getSession(any(UUID.class))).thenReturn(session);
        doNothing().when(sessionDao).closeSession(any(UUID.class));

        assertTrue(sessionService.isSessionClosed(session.getId()));
        verify(sessionDao, times(1)).closeSession(any(UUID.class));
    }

    @Test
    public void testIfSessionIsNotClosed() {
        final SessionEntity session = createSession();
        session.setStatus(true);
        session.setSessionDuration(LocalDateTime.now().plusMinutes(1));
        when(sessionDao.getSession(any(UUID.class))).thenReturn(session);

        assertFalse(sessionService.isSessionClosed(session.getId()));
    }

    private SessionEntity createSession() {
        final SessionEntity session = new SessionEntity();

        session.setId(UUID.fromString("1c4265df-a31f-4c01-8854-4892dc32d085"));
        session.setStatus(true);
        session.setSessionAgenda(UUID.fromString("0fb04084-dea9-46fd-b63b-d6dfd29bdae7"));
        session.setSessionCreateTime(LocalDateTime.now());
        session.setSessionDuration(LocalDateTime.now().plusMinutes(1));
        return session;
    }
}
