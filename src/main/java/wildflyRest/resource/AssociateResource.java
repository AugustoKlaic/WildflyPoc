package wildflyRest.resource;

import wildflyRest.dao.AssociateDao;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/voters")
@Produces(MediaType.APPLICATION_JSON)
public class AssociateResource {

    private AssociateDao associateDao = new AssociateDao();


    @GET
    public Response getAllAssociates() {
        return Response.ok().entity(associateDao.getAllAssociates()).build();
    }
}
