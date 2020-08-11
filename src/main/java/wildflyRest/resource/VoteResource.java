package wildflyRest.resource;

import wildflyRest.converter.VoteConverter;
import wildflyRest.dto.input.VoteInput;
import wildflyRest.service.VoteService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/votes")
@Produces(MediaType.APPLICATION_JSON)
public class VoteResource {

    private VoteService voteService = new VoteService();

    @GET
    @Path("{id}")
    public Response getVoteResults(@PathParam("id") String id) {
        return Response.status(Response.Status.OK).entity(voteService.getResults(UUID.fromString(id))).build();
    }

    @POST
    public Response vote(final VoteInput voteInput) {
        voteService.vote(VoteConverter.convertToEntity(voteInput));
        return Response.status(Response.Status.OK).build();
    }

}
