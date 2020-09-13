package wildflyRest.session;

import java.time.LocalDateTime;

public class SessionConverter {

    public SessionEntity convertInputToEntity(SessionInput session) {
        final SessionEntity sessionEntity = new SessionEntity();

        sessionEntity.setSessionAgenda(session.getSessionAgenda());
        sessionEntity.setSessionCreateTime(LocalDateTime.parse(session.getSessionCreateTime()));
        if(session.getSessionDuration() == null){
            sessionEntity.setSessionDuration(null);
        }else{

            sessionEntity.setSessionDuration(LocalDateTime.parse(session.getSessionDuration()));
        }
        sessionEntity.setStatus(true);

        return sessionEntity;
    }
}
