package wildflyRest.agenda;

import javax.inject.Singleton;

@Singleton
public class AgendaConverter {

    public AgendaEntity convertInputToEntity(AgendaInput agendaInput) {
        final AgendaEntity agendaEntity = new AgendaEntity();

        agendaEntity.setName(agendaInput.getName());

        return agendaEntity;
    }
}
