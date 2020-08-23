package wildflyRest.agenda;


public class AgendaInput {

    private String name;

    public AgendaInput(String name) {
        this();
        this.name = name;
    }

    public AgendaInput() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
