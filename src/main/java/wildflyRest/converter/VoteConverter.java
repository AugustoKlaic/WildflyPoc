package wildflyRest.converter;

import wildflyRest.dto.input.VoteInput;
import wildflyRest.entity.VoteEntity;

import javax.inject.Singleton;

@Singleton
public class VoteConverter {

    public static VoteEntity convertToEntity(VoteInput voteInput) {
        final VoteEntity voteEntity = new VoteEntity();

        voteEntity.setVoteAgenda(voteInput.getAgendaId());
        voteEntity.setVoteAssociate(voteInput.getAssociateId());
        voteEntity.setVoteValue(voteInput.getVote());

        return voteEntity;
    }
}
