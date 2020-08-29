package wildflyRest.session;

import java.util.UUID;

public class SessionInput {

    private UUID sessionAgenda;
    private String sessionDuration;
    private String sessionCreateTime;

    public SessionInput() {
    }

    public SessionInput(UUID sessionAgenda, String sessionDuration, String sessionCreateTime) {
        this();
        this.sessionAgenda = sessionAgenda;
        this.sessionDuration = sessionDuration;
        this.sessionCreateTime = sessionCreateTime;
    }

    public UUID getSessionAgenda() {
        return sessionAgenda;
    }

    public void setSessionAgenda(UUID sessionAgenda) {
        this.sessionAgenda = sessionAgenda;
    }

    public String getSessionDuration() {
        return sessionDuration;
    }

    public void setSessionDuration(String sessionDuration) {
        this.sessionDuration = sessionDuration;
    }

    public String getSessionCreateTime() {
        return sessionCreateTime;
    }

    public void setSessionCreateTime(String sessionCreateTime) {
        this.sessionCreateTime = sessionCreateTime;
    }
}
