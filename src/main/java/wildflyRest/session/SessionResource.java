package wildflyRest.session;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Path("/sessions")
@Produces(MediaType.APPLICATION_JSON)
public class SessionResource {

    private final SessionService sessionService;

    @Inject
    public SessionResource(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GET
    public Response getAllSession(){
        final List<SessionEntity> sessions = sessionService.getAllSessions();
        return Response.status(Response.Status.OK).entity(sessions).build();
    }

    @POST
    @Path("/new")
    public Response createSession(SessionInput session) {
        if (session.getSessionAgenda() != null && session.getSessionCreateTime() != null) {
            final UUID sessionId = sessionService.insertSession(SessionConverter.convertInputToEntity(session));
            return Response.status(Response.Status.CREATED).entity(sessionId).build();
        } else {
            return Response.status(Response.Status.CONFLICT)
                    .entity("{\"code\" : 409, \"message\" : \"Could not create this session, missing information.\"}").build();
        }
    }
}
