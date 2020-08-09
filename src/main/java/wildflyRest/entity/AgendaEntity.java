package wildflyRest.entity;

import javax.persistence.*;
import java.time.Duration;
import java.util.UUID;

@Entity
@Table(name = "agenda")
public class AgendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "agenda_id")
    private UUID id;

    @Column(name = "agenda_name", unique = true, nullable = false)
    private String name;

    @Column(name = "agenda_duration", nullable = false)
    private Duration duration;

    public AgendaEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}
