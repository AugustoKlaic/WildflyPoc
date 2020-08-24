package wildflyRest.session;

import java.time.LocalDateTime;
import java.util.UUID;

public class SessionInput {

    private UUID sessionAgenda;
    private Integer sessionDuration;
    private String sessionCreateTime;

    public SessionInput() {
    }

    public SessionInput(UUID sessionAgenda, Integer sessionDuration, String sessionCreateTime) {
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

    public Integer getSessionDuration() {
        return sessionDuration;
    }

    public void setSessionDuration(Integer sessionDuration) {
        this.sessionDuration = sessionDuration;
    }

    public String getSessionCreateTime() {
        return sessionCreateTime;
    }

    public void setSessionCreateTime(String sessionCreateTime) {
        this.sessionCreateTime = sessionCreateTime;
    }
}
