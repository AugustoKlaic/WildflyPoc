package wildflyRest.session;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public class SessionService {

    private final SessionDao sessionDao = new SessionDao();

    @Transactional
    public void insertSession(SessionEntity session) {
        if (session.getSessionAgenda() != null && session.getSessionCreateTime() != null) {
            sessionDao.insertSession(session);
        }
    }

    public List<SessionEntity> getAllSessions() {
        return sessionDao.getAllSessions();
    }

    public SessionEntity getSession(UUID sessionId) {
        return sessionDao.getSession(sessionId);
    }

    public Boolean isSessionClosed(UUID sessionId) {
        return false;
    }
}
