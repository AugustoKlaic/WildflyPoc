package wildflyRest.queueManagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import wildflyRest.vote.VoteResultOutput;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class VoteResultProducer {

    private static final String QUEUE_NAME = "voteResultQueue";
    private static final String EXCHANGE_NAME = "voteResultExchange";
    private static final String HOST = "localhost";
    private static final Integer PORT = 5672;
    private static final String USER = "voter";
    private static final String PASSWORD = "v0t3r";

    ObjectMapper objectMapper = new ObjectMapper();

    public void sendResultToQueue(VoteResultOutput voteResultOutput) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        factory.setPort(PORT);
        factory.setUsername(USER);
        factory.setPassword(PASSWORD);
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            String message = objectMapper.writeValueAsString(voteResultOutput);
            channel.basicPublish(EXCHANGE_NAME, QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
        } catch (TimeoutException | IOException e) {
            e.printStackTrace();
        }
    }
}
