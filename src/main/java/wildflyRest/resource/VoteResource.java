package wildflyRest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/votes")
@Produces(MediaType.APPLICATION_JSON)
public class VoteResource {

    @GET
    public Response getVoteResults() {

    }

    @POST
    public Response vote() {

    }

}
