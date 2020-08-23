package wildflyRest.service.cpfValidator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class CpfValidatorService {

    private static final String URL = "https://user-info.herokuapp.com/users/";

    private final ObjectMapper objectMapper = new ObjectMapper();

    public CpfStatus isAbleToVote(String cpf) throws JsonProcessingException {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(URL).path(cpf);
        Invocation.Builder invocationBuilder = webTarget.request().accept(MediaType.APPLICATION_JSON_TYPE);

        String response = invocationBuilder.get().readEntity(String.class);
        return objectMapper.readValue(response, CpfStatus.class);
    }
}
