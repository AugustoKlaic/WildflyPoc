package vote;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import wildflyRest.vote.VoteConverter;
import wildflyRest.vote.VoteEntity;
import wildflyRest.vote.VoteInput;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class VoteConverterTest {

    @InjectMocks
    private VoteConverter voteConverter;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testIfConvertVote(){
        final VoteInput voteInput = createVoteInput();
        VoteEntity response = voteConverter.convertToEntity(voteInput);

        assertEquals(voteInput.getAgendaId(), response.getVoteAgenda());
        assertEquals(voteInput.getAssociateCpf(), response.getVoteAssociate());
        assertEquals(voteInput.getSessionId(), response.getVoteSession());
        assertEquals(voteInput.getVote(), response.getVoteValue());
    }

    private VoteInput createVoteInput(){
        final VoteInput voteInput = new VoteInput();
        voteInput.setAgendaId(UUID.fromString("dddfd8f6-c45e-41d5-86ef-910ac3ca6cfa"));
        voteInput.setAssociateCpf("84307145656");
        voteInput.setSessionId(UUID.fromString("dddfd8f6-c45e-41d5-86ef-910ac3ca6cfa"));
        voteInput.setVote(true);

        return voteInput;
    }

}
