package wildflyRest.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "vote")
public class VoteEntity {

    @Column(name = "vote_agenda")
    private UUID voteAgenda;

    @Column(name = "vote_associate")
    private UUID voteAssociate;

    @Column(name = "vote_value")
    private Boolean voteValue;

    public VoteEntity() {
    }

    public UUID getVoteAgenda() {
        return voteAgenda;
    }

    public void setVoteAgenda(UUID voteAgenda) {
        this.voteAgenda = voteAgenda;
    }

    public UUID getVoteAssociate() {
        return voteAssociate;
    }

    public void setVoteAssociate(UUID voteAssociate) {
        this.voteAssociate = voteAssociate;
    }

    public Boolean getVoteValue() {
        return voteValue;
    }

    public void setVoteValue(Boolean voteValue) {
        this.voteValue = voteValue;
    }
}
