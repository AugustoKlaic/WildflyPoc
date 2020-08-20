package wildflyRest.dto.input;

import java.util.UUID;

public class VoteInput {

    private UUID associateId;
    private UUID agendaId;
    private Boolean vote;
    private UUID sessionId;

    public VoteInput(UUID associateId, UUID agendaId, Boolean vote, UUID sessionId) {
        this();
        this.associateId = associateId;
        this.agendaId = agendaId;
        this.vote = vote;
        this.sessionId = sessionId;
    }

    public VoteInput() {
    }

    public UUID getAssociateId() {
        return associateId;
    }

    public void setAssociateId(UUID associateId) {
        this.associateId = associateId;
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
