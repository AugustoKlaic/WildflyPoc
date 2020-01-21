package wildflyRest.resource;

import wildflyRest.entity.AssociateEntity;
import wildflyRest.service.AssociateService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Path("/voters")
@Produces(MediaType.APPLICATION_JSON)
public class AssociateResource {

    private AssociateService associateService = new AssociateService();

    @GET
    public Response getAllAssociates() {
        final List<AssociateEntity> associates = associateService.getAllAssociates();
        return  Response.status(Response.Status.OK).entity(associates).build();
    }

    @GET
    @Path("/{id}")
    public Response getAssociate(@PathParam("id") String id) {
        final UUID associateId;

        try {
            associateId = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("{\"code\" : 400, \"message\" : \"Wrong format of UUID\"}").build();
        }

        final Optional<AssociateEntity> associate = associateService.getAssociate(associateId);
        if (associate.isPresent()) {
            return Response.status(Response.Status.OK).entity(associate.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("{\"code\" : 404, \"message\" : \"No Associates found with this Id\"}").build();
        }
    }
}
