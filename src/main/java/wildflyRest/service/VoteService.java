package wildflyRest.service;

import wildflyRest.dao.VoteDao;
import wildflyRest.dto.output.VoteResultOutput;
import wildflyRest.entity.VoteEntity;

import javax.transaction.Transactional;
import java.util.UUID;

public class VoteService {

    private VoteDao voteDao = new VoteDao();

    @Transactional
    public void vote(VoteEntity voteEntity) {
        voteDao.vote(voteEntity);
    }

    public VoteResultOutput getResults(UUID agendaId) {
        return voteDao.votingResult(agendaId);
    }
}
