package wildflyRest.dto.input;

import java.time.Duration;

public class AgendaInput {

    private String name;
    private Duration duration;

    public AgendaInput(String name, Duration duration) {
        this();
        this.name = name;
        this.duration = duration;
    }

    public AgendaInput() {
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
