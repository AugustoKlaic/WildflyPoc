package wildflyRest.dto.input;

import java.time.LocalDateTime;
import java.util.UUID;

public class SessionInput {

    private UUID sessionAgenda;
    private Integer sessionDuration;
    private LocalDateTime sessionCreateTime;

    public SessionInput() {
    }

    public SessionInput(UUID sessionAgenda, Integer sessionDuration, LocalDateTime sessionCreateTime) {
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

    public LocalDateTime getSessionCreateTime() {
        return sessionCreateTime;
    }

    public void setSessionCreateTime(LocalDateTime sessionCreateTime) {
        this.sessionCreateTime = sessionCreateTime;
    }
}
