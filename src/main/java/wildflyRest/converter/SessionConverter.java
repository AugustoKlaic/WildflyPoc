package wildflyRest.converter;

import wildflyRest.dto.input.SessionInput;
import wildflyRest.entity.SessionEntity;

public class SessionConverter {

    public static SessionEntity convertInputToEntity(SessionInput session){
        final SessionEntity sessionEntity = new SessionEntity();

        sessionEntity.setSessionAgenda(session.getSessionAgenda());
        sessionEntity.setSessionCreateTime(session.getSessionCreateTime());
        sessionEntity.setSessionDuration(session.getSessionDuration());

        return sessionEntity;
    }
}
