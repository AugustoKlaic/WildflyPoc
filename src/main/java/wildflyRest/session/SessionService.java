package wildflyRest.session;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class SessionService {

    private final SessionDao sessionDao = new SessionDao();

    @Transactional
    public UUID insertSession(SessionEntity session) {
        if (session.getSessionAgenda() != null && session.getSessionCreateTime() != null) {
            return sessionDao.insertSession(session);
        } else return null;
    }

    public List<SessionEntity> getAllSessions() {
        return sessionDao.getAllSessions();
    }

    public SessionEntity getSession(UUID sessionId) {
        return sessionDao.getSession(sessionId);
    }

    public Boolean isSessionClosed(UUID sessionId) {
        final SessionEntity session = getSession(sessionId);
        final LocalDateTime actualTime = LocalDateTime.now();

        if(!session.getStatus()) {
            return true;
        } else if (actualTime.isAfter(session.getSessionDuration())){
            return true;
        } else return false;
    }
}
