package wildflyRest.agenda;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AgendaService {

    private final AgendaDao agendaDao = new AgendaDao();

    public List<AgendaEntity> getAllAgendas() {
        return agendaDao.getAllAgendas();
    }

    public Optional<AgendaEntity> getAgenda(UUID agendaId) {
        if (agendaId != null) {
            return Optional.of(agendaDao.getAgenda(agendaId));
        } else {
            return Optional.empty();
        }
    }

    @Transactional
    public void insertAgenda(AgendaEntity agendaEntity) {
        if (agendaEntity != null && agendaEntity.getName() != null) {
            agendaDao.insertAgenda(agendaEntity);
        }
    }
}
