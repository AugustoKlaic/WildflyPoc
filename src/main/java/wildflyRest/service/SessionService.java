package wildflyRest.service;

import wildflyRest.dao.SessionDao;
import wildflyRest.entity.SessionEntity;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.UUID;

public class SessionService {

    private SessionDao sessionDao = new SessionDao();

    @Transactional
    public void insertSession(SessionEntity session) {
        if (session.getSessionAgenda() != null && session.getSessionCreateTime() != null) {
            sessionDao.insertSession(session);
        }
    }

    public SessionEntity getSession(UUID sessionId) {
        return sessionDao.getSession(sessionId);
    }

    public Boolean isSessionClosed(UUID sessionId) {
        final SessionEntity session = getSession(sessionId);
        final LocalDateTime startTime = session.getSessionCreateTime();

        if (LocalDateTime.now().isAfter(startTime.plusMinutes(session.getSessionDuration()))) {
            return true;
        } else {
            return false;
        }
    }
}
