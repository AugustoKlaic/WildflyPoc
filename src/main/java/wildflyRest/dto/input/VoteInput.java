package wildflyRest.dto.input;

import java.util.UUID;

public class VoteInput {

    private UUID associateId;
    private UUID agendaId;
    private Boolean vote;

    public VoteInput(UUID associateId, UUID agendaId, Boolean vote) {
        this();
        this.associateId = associateId;
        this.agendaId = agendaId;
        this.vote = vote;
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
}
