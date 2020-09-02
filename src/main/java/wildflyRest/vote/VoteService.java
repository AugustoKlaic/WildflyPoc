package wildflyRest.vote;

import wildflyRest.queueManagement.VoteResultProducer;
import wildflyRest.session.SessionClosedException;
import wildflyRest.session.SessionService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public class VoteService {

    private final VoteDao voteDao = new VoteDao();
    private final SessionService sessionService = new SessionService();
    private final VoteResultProducer voteResultProducer = new VoteResultProducer();

    @Transactional
    public void vote(VoteEntity voteEntity) throws SessionClosedException {
        if (sessionService.isSessionClosed(voteEntity.getVoteSession())) {
            throw new SessionClosedException("Session is already closed.");
        } else {
            voteDao.vote(voteEntity);
        }
    }

    public VoteResultOutput getResults(UUID agendaId) {
        List<VoteEntity> votes = voteDao.votingResult(agendaId);

        long yes = votes.stream().filter(VoteEntity::getVoteValue).count();
        long no = votes.stream().filter(vote -> !vote.getVoteValue()).count();
        long total = yes + no;

        final VoteResultOutput voteResultOutput = new VoteResultOutput(yes, no, total);;

        sessionService.closeSession(agendaId);
        voteResultProducer.sendResultToQueue(voteResultOutput);
        return voteResultOutput;
    }
}
