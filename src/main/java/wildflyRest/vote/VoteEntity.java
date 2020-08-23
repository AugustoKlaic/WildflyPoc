package wildflyRest.vote;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "vote")
public class VoteEntity implements Serializable {

    private static final long serialVersionUID = 3984905683591704185L;

    @Id
    @Column(name = "vote_agenda")
    private UUID voteAgenda;

    @Id
    @Column(name = "vote_associate")
    private String voteAssociate;

    @Column(name = "vote_value")
    private Boolean voteValue;

    @Column(name = "vote_session")
    private UUID voteSession;

    public VoteEntity() {
    }

    public UUID getVoteAgenda() {
        return voteAgenda;
    }

    public void setVoteAgenda(UUID voteAgenda) {
        this.voteAgenda = voteAgenda;
    }

    public String getVoteAssociate() {
        return voteAssociate;
    }

    public void setVoteAssociate(String voteAssociate) {
        this.voteAssociate = voteAssociate;
    }

    public Boolean getVoteValue() {
        return voteValue;
    }

    public void setVoteValue(Boolean voteValue) {
        this.voteValue = voteValue;
    }

    public UUID getVoteSession() {
        return voteSession;
    }

    public void setVoteSession(UUID voteSession) {
        this.voteSession = voteSession;
    }
}
