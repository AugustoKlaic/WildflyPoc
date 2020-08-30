package wildflyRest.vote;

import wildflyRest.session.SessionService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public class VoteService {

    private final VoteDao voteDao = new VoteDao();
    private final SessionService sessionService = new SessionService();

    @Transactional
    public void vote(VoteEntity voteEntity) throws Exception {
        if (sessionService.isSessionClosed(voteEntity.getVoteSession())) {
            throw new Exception();
        } else {
            voteDao.vote(voteEntity);
        }
    }

    public VoteResultOutput getResults(UUID agendaId) {
        List<VoteEntity> votes = voteDao.votingResult(agendaId);

        long yes = votes.stream().filter(VoteEntity::getVoteValue).count();
        long no = votes.stream().filter(vote -> !vote.getVoteValue()).count();
        long total = yes + no;

        sessionService.closeSession(agendaId);
        return new VoteResultOutput(yes, no, total);
    }
}
