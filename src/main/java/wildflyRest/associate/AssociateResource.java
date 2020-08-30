package wildflyRest.associate;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/associates")
@Produces(MediaType.APPLICATION_JSON)
public class AssociateResource {

    private final AssociateService associateService = new AssociateService();

    @GET
    public Response getAllAssociates() {
        final List<AssociateEntity> associates = associateService.getAllAssociates();
        return Response.status(Response.Status.OK).entity(associates).build();
    }

    @POST
    @Path("/new")
    public Response insertAssociate(final AssociateInput associateInput) {

        if (associateInput != null && associateInput.getAssociateCpf() != null && associateInput.getAssociateName() != null) {
            final String cpf =  associateService.insertAssociate(AssociateConverter.convertInputToEntity(associateInput));
            return Response.status(Response.Status.CREATED).entity(cpf).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"code\" : 400, \"message\" : \"Could not create this associate, missing information.\"}").build();
        }
    }
}
