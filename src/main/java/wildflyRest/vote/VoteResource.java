package wildflyRest.vote;

import wildflyRest.cpfValidator.CpfUnableToVoteException;
import wildflyRest.cpfValidator.InvalidCpfException;
import wildflyRest.session.SessionClosedException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/votes")
@Produces(MediaType.APPLICATION_JSON)
public class VoteResource {

    private final VoteService voteService;

    @Inject
    public VoteResource(VoteService voteService) {
        this.voteService = voteService;
    }

    @GET
    @Path("/{id}")
    public Response getVoteResults(@PathParam("id") String id) {
        return Response.status(Response.Status.OK).entity(voteService.getResults(UUID.fromString(id))).build();
    }

    @POST
    @Path("/vote")
    public Response vote(final VoteInput voteInput) {
        try {
            voteService.vote(VoteConverter.convertToEntity(voteInput));
            return Response.status(Response.Status.OK).build();
        } catch (SessionClosedException | InvalidCpfException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("{\"code\" : 400, \"message\" : " + e.getMessage() + "}").build();
        } catch (UniqueVoteException e) {
            return Response.status(Response.Status.CONFLICT).entity("{\"code\" : 409, \"message\" :" + e.getMessage() + "}").build();
        } catch (CpfUnableToVoteException e) {
            return Response.status(Response.Status.FORBIDDEN).entity("{\"code\" : 403, \"message\" :" + e.getMessage() + "}").build();
        }
    }
}
