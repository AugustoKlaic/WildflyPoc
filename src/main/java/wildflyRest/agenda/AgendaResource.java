package wildflyRest.agenda;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Path("/agendas")
@Produces(MediaType.APPLICATION_JSON)
public class AgendaResource {

    private final AgendaService agendaService;
    private final AgendaConverter agendaConverter;

    @Inject
    public AgendaResource(AgendaService agendaService, AgendaConverter agendaConverter) {
        this.agendaService = agendaService;
        this.agendaConverter = agendaConverter;
    }

    @GET
    public Response getAllAgendas() {
        final List<AgendaEntity> agendas = agendaService.getAllAgendas();
        return Response.status(Response.Status.OK).entity(agendas).build();
    }

    @POST
    @Path("/new")
    public Response insertAgenda(AgendaInput agendaInput) {
        if (agendaInput != null && agendaInput.getName() != null) {
            final UUID agendaId = agendaService.insertAgenda(agendaConverter.convertInputToEntity(agendaInput));
            return Response.status(Response.Status.CREATED).entity(agendaId).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"code\" : 400, \"message\" : \"Could not create this agenda, missing information.\"}").build();
        }
    }
}
