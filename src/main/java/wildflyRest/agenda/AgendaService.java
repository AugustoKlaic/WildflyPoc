package wildflyRest.agenda;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public class AgendaService {

    private final AgendaDao agendaDao = new AgendaDao();

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
