package wildflyRest.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import wildflyRest.converter.VoteConverter;
import wildflyRest.dto.input.VoteInput;
import wildflyRest.service.SessionService;
import wildflyRest.service.VoteService;
import wildflyRest.service.cpfValidator.CpfValidatorService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/votes")
@Produces(MediaType.APPLICATION_JSON)
public class VoteResource {

    private static final String UNABLE_TO_VOTE = "UNABLE_TO_VOTE";

    private final VoteService voteService = new VoteService();
    private final SessionService sessionService = new SessionService();
    private final CpfValidatorService cpfValidatorService = new CpfValidatorService();


    @GET
    @Path("/{id}")
    public Response getVoteResults(@PathParam("id") String id) {
        return Response.status(Response.Status.OK).entity(voteService.getResults(UUID.fromString(id))).build();
    }

    @POST
    @Path("/vote")
    public Response vote(final VoteInput voteInput) {
        try {
            String status = cpfValidatorService.isAbleToVote("").getCpfStatus();
            if(status.equals(UNABLE_TO_VOTE)){
                return Response.status(Response.Status.UNAUTHORIZED).entity("{\"code\" : 401, \"message\" : \"CPF unable to vote.\"}").build();
            }
        } catch (JsonProcessingException e) {
            return Response.status(Response.Status.NOT_FOUND).entity("{\"code\" : 404, \"message\" : \"Invalid CPF.\"}").build();
        }

        if (sessionService.isSessionClosed(voteInput.getSessionId())) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("{\"code\" : 401, \"message\" : \"Voting Session already closed.\"}").build();
        } else {
            voteService.vote(VoteConverter.convertToEntity(voteInput));
            return Response.status(Response.Status.OK).build();
        }
    }
}
