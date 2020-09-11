package service.cpfValidator;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import wildflyRest.cpfValidator.CpfValidatorService;

import javax.ws.rs.core.Application;

public class cpfValidatorServiceTest extends JerseyTest {


    @Test
    public void testCpfValidationCall() {

    }

    @Override
    protected Application configure() {

        return new ResourceConfig(CpfValidatorService.class);
    }
}
