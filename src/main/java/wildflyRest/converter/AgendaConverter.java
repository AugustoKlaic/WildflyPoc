package wildflyRest.converter;

import wildflyRest.dto.input.AgendaInput;
import wildflyRest.entity.AgendaEntity;

import javax.inject.Singleton;

@Singleton
public class AgendaConverter {

    public static AgendaEntity convertInputToEntity(AgendaInput agendaInput) {
        final AgendaEntity agendaEntity = new AgendaEntity();

        agendaEntity.setDuration(agendaInput.getDuration());
        agendaEntity.setName(agendaInput.getName());

        return agendaEntity;
    }
}
