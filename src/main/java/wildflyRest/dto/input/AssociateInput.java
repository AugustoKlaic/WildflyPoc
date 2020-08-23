package wildflyRest.dto.input;

public class AssociateInput {


    private String associateCpf;
    private String associateName;

    public AssociateInput(String associateCpf, String associateName) {
        this();
        this.associateCpf = associateCpf;
        this.associateName = associateName;
    }

    public AssociateInput() {
    }

    public String getAssociateCpf() {
        return associateCpf;
    }

    public void setAssociateCpf(String asociateCpf) {
        this.associateCpf = asociateCpf;
    }

    public String getAssociateName() {
        return associateName;
    }

    public void setAssociateName(String associateName) {
        this.associateName = associateName;
    }
}
