package service.cpfValidator;

import org.junit.Test;

import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;

public class cpfValidatorServiceTest extends JerseyTest {

    private static final String URL = "/users/";

    @Test
    public void testCpfValidationCall() {

    }

    @Override
    protected AppDescriptor configure() {
        return new WebAppDescriptor.Builder().build();
    }
}
