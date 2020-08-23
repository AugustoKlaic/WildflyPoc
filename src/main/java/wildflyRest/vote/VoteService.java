package wildflyRest.vote;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public class VoteService {

    private final VoteDao voteDao = new VoteDao();

    @Transactional
    public void vote(VoteEntity voteEntity) {
        voteDao.vote(voteEntity);
    }

    public VoteResultOutput getResults(UUID agendaId) {
        List<VoteEntity> votes = voteDao.votingResult(agendaId);

        long yes = votes.stream().filter(VoteEntity::getVoteValue).count();
        long no = votes.stream().filter(vote -> !vote.getVoteValue()).count();
        long total = yes + no;

        return new VoteResultOutput(yes, no, total);
    }
}
