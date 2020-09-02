package wildflyRest.vote;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.hibernate.exception.ConstraintViolationException;
import wildflyRest.cpfValidator.CpfValidatorService;
import wildflyRest.session.SessionClosedException;

import javax.persistence.RollbackException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/votes")
@Produces(MediaType.APPLICATION_JSON)
public class VoteResource {

    private static final String UNABLE_TO_VOTE = "UNABLE_TO_VOTE";

    private final VoteService voteService = new VoteService();
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
            String status = cpfValidatorService.isAbleToVote(voteInput.getAssociateCpf()).getCpfStatus();
            if (status.equals(UNABLE_TO_VOTE)) {
                return Response.status(Response.Status.UNAUTHORIZED).entity("{\"code\" : 401, \"message\" : \"CPF unable to vote.\"}").build();
            }
            voteService.vote(VoteConverter.convertToEntity(voteInput));
            return Response.status(Response.Status.OK).build();
        } catch (JsonProcessingException e) {
            return Response.status(Response.Status.NOT_FOUND).entity("{\"code\" : 404, \"message\" : \"Invalid CPF.\"}").build();
        } catch (SessionClosedException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("{\"code\" : 400, \"message\" : "+ e.getMessage() +"}").build();
        } catch (RollbackException e) {
            return Response.status(Response.Status.CONFLICT).entity("{\"code\" : 409, \"message\" : \"Associate already voted in this agenda.\"}").build();
        }
    }
}
