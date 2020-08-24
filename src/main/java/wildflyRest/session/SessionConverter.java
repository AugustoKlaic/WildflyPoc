package wildflyRest.session;

import java.time.LocalDateTime;

public class SessionConverter {

    public static SessionEntity convertInputToEntity(SessionInput session) {
        final SessionEntity sessionEntity = new SessionEntity();

        sessionEntity.setSessionAgenda(session.getSessionAgenda());
        sessionEntity.setSessionCreateTime(LocalDateTime.parse(session.getSessionCreateTime()));
        sessionEntity.setSessionDuration(session.getSessionDuration());

        return sessionEntity;
    }
}
