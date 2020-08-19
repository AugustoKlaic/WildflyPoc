package wildflyRest.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "session")
@DynamicInsert
public class SessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "session_id")
    private UUID id;

    @Column(name = "session_agenda")
    private UUID sessionAgenda;

    @Column(name = "session_duration")
    @ColumnDefault("1")
    private Integer sessionDuration;

    @Column(name = "session_creation_time")
    private LocalDateTime sessionCreateTime;

    public SessionEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
