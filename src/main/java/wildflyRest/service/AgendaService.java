package wildflyRest.service;

import wildflyRest.dao.AgendaDao;
import wildflyRest.entity.AgendaEntity;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AgendaService {

    private AgendaDao agendaDao = new AgendaDao();

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
