package wildflyRest.service;

import wildflyRest.dao.VoteDao;
import wildflyRest.dto.output.VoteResultOutput;
import wildflyRest.entity.VoteEntity;

import java.util.UUID;

public class VoteService {

    private VoteDao voteDao = new VoteDao();

    public void vote(VoteEntity voteEntity) {
        voteDao.vote(voteEntity);
    }

    public VoteResultOutput getResults(UUID agendaId) {
        return voteDao.votingResult(agendaId);
    }
}
