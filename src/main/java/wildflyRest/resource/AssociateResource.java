package wildflyRest.resource;

import wildflyRest.converter.AssociateConverter;
import wildflyRest.dto.input.AssociateInput;
import wildflyRest.entity.AssociateEntity;
import wildflyRest.service.AssociateService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/associates")
@Produces(MediaType.APPLICATION_JSON)
public class AssociateResource {

    private final AssociateService associateService = new AssociateService();

    @GET
    public Response getAllAssociates() {
        final List<AssociateEntity> associates = associateService.getAllAssociates();
        return Response.status(Response.Status.OK).entity(associates).build();
    }

    @GET
    @Path("/{cpf}")
    public Response getAssociate(@PathParam("cpf") String cpf) {
        final Optional<AssociateEntity> associate = associateService.getAssociate(cpf);
        if (associate.isPresent()) {
            return Response.status(Response.Status.OK).entity(associate.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("{\"code\" : 404, \"message\" : \"No Associates found with this CPF.\"}").build();
        }
    }

    @POST
    @Path("/new")
    public Response insertAssociate(final AssociateInput associateInput) {

        if (associateInput != null && associateInput.getAssociateCpf() != null && associateInput.getAssociateName() != null) {
            associateService.insertAssociate(AssociateConverter.convertInputToEntity(associateInput));
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.CONFLICT)
                    .entity("{\"code\" : 409, \"message\" : \"Could not create this associate, missing information.\"}").build();
        }
    }
}
