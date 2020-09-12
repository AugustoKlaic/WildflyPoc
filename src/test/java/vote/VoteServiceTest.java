package vote;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import wildflyRest.cpfValidator.CpfStatus;
import wildflyRest.cpfValidator.CpfUnableToVoteException;
import wildflyRest.cpfValidator.CpfValidatorService;
import wildflyRest.cpfValidator.InvalidCpfException;
import wildflyRest.queueManagement.VoteResultProducer;
import wildflyRest.session.SessionClosedException;
import wildflyRest.session.SessionService;
import wildflyRest.vote.*;

import javax.persistence.RollbackException;
import java.util.Collections;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class VoteServiceTest {

    private static final String ABLE_TO_VOTE = "ABLE_TO_VOTE";
    private static final String UNABLE_TO_VOTE = "UNABLE_TO_VOTE";

    @InjectMocks
    private VoteService voteService;

    @Mock
    private VoteDao voteDao;

    @Mock
    private SessionService sessionService;

    @Mock
    private CpfValidatorService cpfValidatorService;

    @Mock
    private VoteResultProducer voteResultProducer;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testIfVote() throws JsonProcessingException, UniqueVoteException, SessionClosedException, InvalidCpfException, CpfUnableToVoteException {
        CpfStatus cpfStatus = new CpfStatus(ABLE_TO_VOTE);
        doNothing().when(voteDao).vote(any(VoteEntity.class));
        when(cpfValidatorService.isAbleToVote(any(String.class))).thenReturn(cpfStatus);
        when(sessionService.isSessionClosed(any(UUID.class))).thenReturn(false);

        voteService.vote(createVote());
        verify(voteDao, times(1)).vote(any(VoteEntity.class));
        verify(cpfValidatorService, times(1)).isAbleToVote(any(String.class));
        verify(sessionService, times(1)).isSessionClosed(any(UUID.class));
    }

    @Test(expected = CpfUnableToVoteException.class)
    public void testIfCpfIsUnableToVote() throws JsonProcessingException, UniqueVoteException, SessionClosedException, InvalidCpfException, CpfUnableToVoteException {
        CpfStatus cpfStatus = new CpfStatus(UNABLE_TO_VOTE);
        when(cpfValidatorService.isAbleToVote(any(String.class))).thenReturn(cpfStatus);
        when(sessionService.isSessionClosed(any(UUID.class))).thenReturn(false);

        voteService.vote(createVote());
        verify(cpfValidatorService, times(1)).isAbleToVote(any(String.class));
    }

    @Test
    public void testIfCpfIsAbleToVote() throws JsonProcessingException, UniqueVoteException, SessionClosedException, InvalidCpfException, CpfUnableToVoteException {
        CpfStatus cpfStatus = new CpfStatus(ABLE_TO_VOTE);
        when(cpfValidatorService.isAbleToVote(any(String.class))).thenReturn(cpfStatus);
        when(sessionService.isSessionClosed(any(UUID.class))).thenReturn(false);
        doNothing().when(voteDao).vote(any(VoteEntity.class));

        voteService.vote(createVote());
        verify(cpfValidatorService, times(1)).isAbleToVote(any(String.class));
        verify(voteDao, times(1)).vote(any(VoteEntity.class));
    }

    @Test(expected = SessionClosedException.class)
    public void testIfSessionIsClosedForVoting() throws UniqueVoteException, SessionClosedException, InvalidCpfException, CpfUnableToVoteException {
        when(sessionService.isSessionClosed(any(UUID.class))).thenReturn(true);
        voteService.vote(createVote());

        verify(sessionService, times(1)).isSessionClosed(any(UUID.class));
    }


    @Test(expected = UniqueVoteException.class)
    public void testIfAssociateAlreadyVoted() throws JsonProcessingException, UniqueVoteException, SessionClosedException, InvalidCpfException, CpfUnableToVoteException {
        CpfStatus cpfStatus = new CpfStatus(ABLE_TO_VOTE);
        doThrow(RollbackException.class).when(voteDao).vote(any(VoteEntity.class));
        when(cpfValidatorService.isAbleToVote(any(String.class))).thenReturn(cpfStatus);
        when(sessionService.isSessionClosed(any(UUID.class))).thenReturn(false);

        voteService.vote(createVote());
    }

    @Test(expected = InvalidCpfException.class)
    public void testIfCpfIsInvalid() throws JsonProcessingException, UniqueVoteException, SessionClosedException, InvalidCpfException, CpfUnableToVoteException {
        doThrow(InvalidCpfException.class).when(cpfValidatorService).isAbleToVote(any(String.class));
        doNothing().when(voteDao).vote(any(VoteEntity.class));
        when(sessionService.isSessionClosed(any(UUID.class))).thenReturn(false);

        final VoteEntity voteEntity = createVote();
        voteEntity.setVoteAssociate("invalid cpf");
        voteService.vote(voteEntity);
    }

    @Test
    public void testIfGetResults() {
        final VoteEntity vote = createVote();
        when(voteDao.votingResult(any(UUID.class))).thenReturn(Collections.singletonList(vote));
        doNothing().when(sessionService).closeSession(any(UUID.class));
        doNothing().when(voteResultProducer).sendResultToQueue(any(VoteResultOutput.class));

        VoteResultOutput response = voteService.getResults(UUID.fromString("1c4265df-a31f-4c01-8854-4892dc32d085"));
        assertEquals(1, response.getTotal());
        assertEquals(0, response.getNo());
        assertEquals(1, response.getYes());
    }

    private VoteEntity createVote() {
        final VoteEntity vote = new VoteEntity();
        vote.setVoteAgenda(UUID.fromString("1c4265df-a31f-4c01-8854-4892dc32d085"));
        vote.setVoteAssociate("94321741076");
        vote.setVoteSession(UUID.fromString("0fb04084-dea9-46fd-b63b-d6dfd29bdae7"));
        vote.setVoteValue(true);

        return vote;
    }
}
