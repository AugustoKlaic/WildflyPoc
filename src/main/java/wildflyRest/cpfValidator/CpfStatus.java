package wildflyRest.cpfValidator;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CpfStatus {

    @JsonProperty("status")
    private String status;

    public CpfStatus(String cpfStatus) {
        this();
        this.status = cpfStatus;
    }

    public CpfStatus() {
    }

    public String getCpfStatus() {
        return status;
    }

    public void setCpfStatus(String cpfStatus) {
        this.status = cpfStatus;
    }
}
