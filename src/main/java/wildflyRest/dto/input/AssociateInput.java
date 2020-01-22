package wildflyRest.dto.input;

public class AssociateInput {


    private String asociateCpf;
    private String associateName;

    public AssociateInput(String asociateCpf, String associateName) {
        this();
        this.asociateCpf = asociateCpf;
        this.associateName = associateName;
    }

    public AssociateInput() {
    }

    public String getAsociateCpf() {
        return asociateCpf;
    }

    public void setAsociateCpf(String asociateCpf) {
        this.asociateCpf = asociateCpf;
    }

    public String getAssociateName() {
        return associateName;
    }

    public void setAssociateName(String associateName) {
        this.associateName = associateName;
    }
}
