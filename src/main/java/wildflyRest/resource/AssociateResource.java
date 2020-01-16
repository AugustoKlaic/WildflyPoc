package wildflyRest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/voters")
public class AssociateResorce {

    @GET
    public Response getAllAssociates(){
        return Response.ok().entity("\"teste\" : \"ok\"").build();
    }
}
