package wildflyRest.resource;

import wildflyRest.converter.VoteConverter;
import wildflyRest.dto.input.VoteInput;
import wildflyRest.service.SessionService;
import wildflyRest.service.VoteService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/votes")
@Produces(MediaType.APPLICATION_JSON)
public class VoteResource {

    private final VoteService voteService = new VoteService();
    private final SessionService sessionService = new SessionService();

    @GET
    @Path("/{id}")
    public Response getVoteResults(@PathParam("id") String id) {
        return Response.status(Response.Status.OK).entity(voteService.getResults(UUID.fromString(id))).build();
    }

    @POST
    @Path("/vote")
    public Response vote(final VoteInput voteInput) {
        if (sessionService.isSessionClosed(voteInput.getSessionId())) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("{\"code\" : 401, \"message\" : \"Voting Session already closed.\"}").build();
        } else {
            voteService.vote(VoteConverter.convertToEntity(voteInput));
            return Response.status(Response.Status.OK).build();
        }
    }
}
