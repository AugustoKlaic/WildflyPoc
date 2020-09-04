package wildflyRest.agenda;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public class AgendaService {

    private final AgendaDao agendaDao;

    @Inject
    public AgendaService(AgendaDao agendaDao) {
        this.agendaDao = agendaDao;
    }

    public List<AgendaEntity> getAllAgendas() {
        return agendaDao.getAllAgendas();
    }

    @Transactional
    public UUID insertAgenda(AgendaEntity agendaEntity) {
        if (agendaEntity != null && agendaEntity.getName() != null) {
            return agendaDao.insertAgenda(agendaEntity);
        } else return null;
    }
}
