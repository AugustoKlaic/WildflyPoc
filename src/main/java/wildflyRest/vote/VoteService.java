package wildflyRest.vote;

import com.fasterxml.jackson.core.JsonProcessingException;
import wildflyRest.cpfValidator.CpfUnableToVoteException;
import wildflyRest.cpfValidator.CpfValidatorService;
import wildflyRest.cpfValidator.InvalidCpfException;
import wildflyRest.queueManagement.VoteResultProducer;
import wildflyRest.session.SessionClosedException;
import wildflyRest.session.SessionService;

import javax.persistence.RollbackException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public class VoteService {

    private static final String ABLE_TO_VOTE = "ABLE_TO_VOTE";
    private static final String UNABLE_TO_VOTE = "UNABLE_TO_VOTE";

    private final VoteDao voteDao = new VoteDao();
    private final SessionService sessionService = new SessionService();
    private final VoteResultProducer voteResultProducer = new VoteResultProducer();
    private final CpfValidatorService cpfValidatorService = new CpfValidatorService();


    @Transactional
    public void vote(VoteEntity voteEntity) throws SessionClosedException, UniqueVoteException, InvalidCpfException, CpfUnableToVoteException {
        if (sessionService.isSessionClosed(voteEntity.getVoteSession())) {
            throw new SessionClosedException("Session is already closed.");
        } else {
            try {
                String status = cpfValidatorService.isAbleToVote(voteEntity.getVoteAssociate()).getCpfStatus();
                if (status.equals(ABLE_TO_VOTE)) {
                    voteDao.vote(voteEntity);
                } else if (status.equals(UNABLE_TO_VOTE)) {
                    throw new CpfUnableToVoteException("CPF is unable to vote.");
                }
            } catch (RollbackException e) {
                throw new UniqueVoteException("Associate already voted for this agenda.");
            } catch (JsonProcessingException e) {
                throw new InvalidCpfException("Invalid CPF.");
            }
        }
    }

    public VoteResultOutput getResults(UUID agendaId) {
        List<VoteEntity> votes = voteDao.votingResult(agendaId);

        long yes = votes.stream().filter(VoteEntity::getVoteValue).count();
        long no = votes.stream().filter(vote -> !vote.getVoteValue()).count();
        long total = yes + no;

        final VoteResultOutput voteResultOutput = new VoteResultOutput(yes, no, total);

        sessionService.closeSession(agendaId);
        voteResultProducer.sendResultToQueue(voteResultOutput);
        return voteResultOutput;
    }
}
