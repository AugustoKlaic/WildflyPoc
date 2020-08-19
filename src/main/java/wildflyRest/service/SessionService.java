package wildflyRest.service;

import wildflyRest.dao.SessionDao;
import wildflyRest.entity.SessionEntity;

import javax.transaction.Transactional;

public class SessionService {

    private SessionDao sessionDao = new SessionDao();

    @Transactional
    public void insertSession(SessionEntity session) {
        if (session.getSessionAgenda() != null && session.getSessionCreateTime() != null && session.getSessionDuration() != null) {
            sessionDao.insertSession(session);
        }
    }
}
