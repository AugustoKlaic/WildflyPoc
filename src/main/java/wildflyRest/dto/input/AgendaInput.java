package wildflyRest.dto.input;

import java.time.Duration;

public class AgendaInput {

    private String name;
    private Integer duration;

    public AgendaInput(String name, Integer duration) {
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
