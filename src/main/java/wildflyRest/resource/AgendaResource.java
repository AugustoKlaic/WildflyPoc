package wildflyRest.resource;

import wildflyRest.converter.AgendaConverter;
import wildflyRest.converter.AssociateConverter;
import wildflyRest.dto.input.AgendaInput;
import wildflyRest.entity.AgendaEntity;
import wildflyRest.service.AgendaService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Path("/agendas")
@Produces(MediaType.APPLICATION_JSON)
public class AgendaResource {

    private AgendaService agendaService = new AgendaService();

    @GET
    public Response getAllAgendas() {
        final List<AgendaEntity> agendas = agendaService.getAllAgendas();
        return Response.status(Response.Status.OK).entity(agendas).build();
    }

    @GET
    @Path("/{id}")
    public Response getAgenda(@PathParam("id") String id) {
        final UUID agendaId;

        try {
            agendaId = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("{\"code\" : 400, \"message\" : \"Wrong format of UUID\"}").build();
        }

        final Optional<AgendaEntity> agenda = agendaService.getAgenda(agendaId);
        if (agenda.isPresent()) {
            return Response.status(Response.Status.OK).entity(agenda.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("{\"code\" : 404, \"message\" : \"No Agendas found with this Id\"}").build();
        }
    }

    @POST
    @Path("/new")
    public Response insertAgenda(AgendaInput agendaInput) {
        if (agendaInput != null && agendaInput.getName() != null ) {
            agendaService.insertAgenda(AgendaConverter.convertInputToEntity(agendaInput));
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.CONFLICT)
                    .entity("{\"code\" : 409, \"message\" : \"Could not create this agenda, missing information.\"}").build();
        }
    }
}
