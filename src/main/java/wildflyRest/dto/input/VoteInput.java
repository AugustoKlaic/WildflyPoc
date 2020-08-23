package wildflyRest.dto.input;

import java.util.UUID;

public class VoteInput {

    private String associateCpf;
    private UUID agendaId;
    private Boolean vote;
    private UUID sessionId;

    public VoteInput(String associateCpf, UUID agendaId, Boolean vote, UUID sessionId) {
        this();
        this.associateCpf = associateCpf;
        this.agendaId = agendaId;
        this.vote = vote;
        this.sessionId = sessionId;
    }

    public VoteInput() {
    }

    public String getAssociateCpf() {
        return associateCpf;
    }

    public void setAssociateCpf(String associateCpf) {
        this.associateCpf = associateCpf;
    }

    public UUID getAgendaId() {
        return agendaId;
    }

    public void setAgendaId(UUID agendaId) {
        this.agendaId = agendaId;
    }

    public Boolean getVote() {
        return vote;
    }

    public void setVote(Boolean vote) {
        this.vote = vote;
    }

    public UUID getSessionId() {
        return sessionId;
    }

    public void setSessionId(UUID sessionId) {
        this.sessionId = sessionId;
    }
}
