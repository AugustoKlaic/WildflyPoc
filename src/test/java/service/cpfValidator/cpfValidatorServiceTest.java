package service.cpfValidator;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class cpfValidatorServiceTest extends JerseyTest {

    private static final String URL = "https://user-info.herokuapp.com/users/";

    @Test
    public void testCpfValidationCall() {
        final String cpf = "86101153053";
        WebResource webResource = client().resource(URL).path(cpf);
        ClientResponse response = webResource.get(ClientResponse.class);
        assertEquals(200, response.getStatus());
        assertEquals(URL + cpf, webResource.toString());
    }

    @Override
    protected AppDescriptor configure() {
        return new WebAppDescriptor.Builder().build();
    }
}
