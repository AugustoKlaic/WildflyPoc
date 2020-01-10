package wildflyRest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/voters")
public class VotersResorce {

    @GET
    public Response getAllVoters(){
        return Response.ok().entity("\"teste\" : \"ok\"").build();
    }
}
