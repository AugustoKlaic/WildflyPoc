package wildflyRest.resource;

import wildflyRest.converter.SessionConverter;
import wildflyRest.dto.input.SessionInput;
import wildflyRest.service.SessionService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/sessions")
@Produces(MediaType.APPLICATION_JSON)
public class SessionResource {

    private final SessionService sessionService = new SessionService();

    @POST
    @Path("/new")
    public Response createSession(SessionInput session) {
        if (session.getSessionAgenda() != null && session.getSessionCreateTime() != null) {
            sessionService.insertSession(SessionConverter.convertInputToEntity(session));
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.CONFLICT)
                    .entity("{\"code\" : 409, \"message\" : \"Could not create this session, missing information.\"}").build();
        }
    }
}
