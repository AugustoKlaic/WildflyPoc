package wildflyRest.vote;

import javax.inject.Singleton;

@Singleton
public class VoteConverter {

    public VoteEntity convertToEntity(VoteInput voteInput) {
        final VoteEntity voteEntity = new VoteEntity();

        voteEntity.setVoteAgenda(voteInput.getAgendaId());
        voteEntity.setVoteAssociate(voteInput.getAssociateCpf());
        voteEntity.setVoteValue(voteInput.getVote());
        voteEntity.setVoteSession(voteInput.getSessionId());

        return voteEntity;
    }
}
